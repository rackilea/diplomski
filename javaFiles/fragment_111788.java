import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class main {


    public static void main(String[] args) {
        Connection conn = null;
    try {
     //Server connection details
     Class.forName("com.mysql.jdbc.Driver");
     String host = "jdbc:mysql://localhost/3306/db";
     String userName = "admin";
     String password = "admin";

     //Get the connection going.

     conn = DriverManager.getConnection(host, userName, password);
    }
    catch (Exception err) { // Catch All otherwise the compiler will flag an uncaught Connection exception
      System.out.println(err.getMessage());
    }
    }}