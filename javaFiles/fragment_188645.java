package com.smy.gome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/root";

    static final String USER = "root";
    static final String PASS = "benux1";

    public static Connection conn = null;
    public static Statement statement = null;
    public static ResultSet results = null;

    public synchronized static void Connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/root", "root", "benux1");
            statement = conn.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void Destroy(){
        try {
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static ResultSet query(String s) throws SQLException {
        try {
            if (s.toLowerCase().startsWith("select")) {
                ResultSet rs = statement.executeQuery(s);
                return rs;
            } else {
                statement.executeUpdate(s);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int checkUser() {
        try {
            ResultSet user = statement.executeQuery("SELECT * FROM tadzio WHERE nick='benas12' AND pass='benas'");
            user.next();
            int count = user.getRow();
            return count;
        } catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getVersion(){

        return "tadis";
    }

}