import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");

        try(Statement statement = conn.createStatement()) {
            statement.execute("PRAGMA user_version = 10;");
        }

        try(Statement statement = conn.createStatement()) {
            try(ResultSet rs = statement.executeQuery("PRAGMA user_version;")) {
                System.out.println(rs.getInt(1));
            }
        }
    }
}