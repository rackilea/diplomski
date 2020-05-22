import java.sql.*;
import java.util.*;

public class phoenixTest
{
    public static void main(String args[]) throws Exception
    {
        Connection conn;
        Properties prop = new Properties();
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        System.out.println("Driver class loaded successfully");

        conn = DriverManager.getConnection("jdbc:phoenix:localhost");
        System.out.println("got connection");

        //WEB_STAT
        ResultSet rst = conn.createStatement().executeQuery("select * from WEB_STAT");
        while (rst.next())
        {
            System.out.println(rst.getString(1) + " " + rst.getString(2));
        }

    }
}