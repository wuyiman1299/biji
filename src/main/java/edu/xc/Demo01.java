package edu.xc;

import com.mysql.jdbc.Driver;

import java.sql.*;

class Demo02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test01", "root", "1299");
        // 3 准备传输器
        Statement statement = connection.createStatement();
        // 4 执行sql
        ResultSet resultSet = statement.executeQuery("select * from book ");
        // 5 获取结果
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                    + resultSet.getString(3) + " " + resultSet.getDouble(4)
            );
        }
        // 6 关闭资源
        resultSet.close();
        statement.close();
        connection.close();


    }

}

