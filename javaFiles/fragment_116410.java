import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String url = "..."; // Specify according to JDBC driver in use
        String sql = "SELECT 1 FROM DUAL"; // Test statement. Change depending on SQL vendor
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {/*Nothing to do*/}
        } catch (SQLException e) {
            // Send email here
        }
    }
}