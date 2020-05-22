package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createdatabase {

    //Number of columns in test table//
    private static int NumberOfColumns = 3;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    static final String USER = "root";
    static final String PASS = "mypass";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql = "CREATE DATABASE mydatabase";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE mydatabase.table (id INTEGER not NULL)";
            stmt.executeUpdate(sql);
            String colname;
            for (int i = 0; i < NumberOfColumns; i++) {
                colname = "Column" + i;
                sql = "ALTER TABLE mydatabase.table ADD " + colname + " VARCHAR(30)";
                stmt.executeUpdate(sql);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception = " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println("Exception" + se);
            }
        }
    }
}