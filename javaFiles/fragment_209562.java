package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DbConnect {

    /**
     * Static method for user authentication
     * Test method
     * @param username - Username already striped from illigal chars (XSS safe)
     * @param pass - password
     */
    public static void connect(String username,String pass)//Consider changing void to boolean
    {
        Connection con;
        PreparedStatement st;
        ResultSet rs;
        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");//Loading DB Driver
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Open a connection
        //  Database credentials
        final String USER = "root";
        final String PASS = "";
        final String DB_URL = "jdbc:mysql://localhost:3306/imf_jsp";
        try {
             con = DriverManager.getConnection(DB_URL,USER,PASS);
             st = con.prepareStatement("SELECT * FROM user WHERE signum = ? AND pass_hash = ?"); //Find user with given username & pass
             st.setString(1, username);//Bind param (Should prevent SQL Injection? Not sure but it is working in PHP with PDO)
             st.setString(2, pass);//Bind param (Should prevent SQL Injection? Not sure but it is working in PHP with PDO)
             st.execute();//statemant execution
             System.out.println("In Database?: " + st.toString());//If not then check in LDAP
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }