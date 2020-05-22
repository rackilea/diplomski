import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.ResultSetMetaData;

public class Db {
    public static void main(String arg[]) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/dbname", "root", "");

        java.sql.Statement stmt = conn.createStatement();
        String query = "select * from music";

        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();

        int columncount = rsmd.getColumnCount();

        for(int i = 1 ; i < columncount ; i ++)
            System.out.print(rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {

            for(int i = 1 ; i < columncount ; i ++)
            {
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }

        conn.close();

    }

}