import java.sql.*;

public class mysqlTestMain {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            String myConnectionString =
                    "jdbc:mysql://localhost:3306/getataxi?" +
                    "useUnicode=yes&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(myConnectionString, "root", "beer");
            Statement stmt = conn.createStatement();
            stmt.execute("SHOW TABLES");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}