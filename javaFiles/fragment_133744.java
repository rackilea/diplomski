import java.sql.DriverManager;

import java.sql.Connection;

import java.sql.Statement;

public class Create

{

    public static void main( String [] args)throws Exception
    {
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/orcl1","scott","sada");
        System.out.println("connection is createad");
        Statement stmt=con.createStatement();
        System.out.println("statemnt of object is createad");
        stmt.executeUpdate("create table iteam(iteamno number(3) primary key,iteamname number(15),price number(4))");
        System.out.println("table is created ");
        con.close();
        stmt.close();
        System.out.println("conncetion closed");
    }
}