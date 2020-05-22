import java.sql.*;

public class UserLogin {
    public static void main(String[] args) 
    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "C:\\bank.accdb";

            Connection conn = DriverManager.getConnection(url, "username", "password");
            System.out.println("Connection Succesfull");
        }
        catch (Exception e) 
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}