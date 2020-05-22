import java.sql.*;

public class JDBCTest {

  public static void main() throws SQLException {

        // Connecting
        try (Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "admin")) {

            // Querying
            String query = "MATCH (u:User)-[:FRIEND]-(f:User) WHERE u.name = {1} RETURN f.name, f.age";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setString(1,"John");

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("Friend: "+rs.getString("f.name")+" is "+rs.getInt("f.age"));
                    }
                }
            }
        }
    }
}