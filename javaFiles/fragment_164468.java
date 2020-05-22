package h2demo;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DemoMain {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test")) {
            try (Statement st = conn.createStatement()) {
                // set up test environment
                st.execute("CREATE TABLE table1 (id INT PRIMARY KEY)");
                st.execute("INSERT INTO table1 (id) VALUES (2)");
            }
            try {
                doBatchUpdate(conn);
            } catch (BatchUpdateException bue) {
                System.out.println("BatchUpdateException caught: " + bue.getMessage());
                System.out.println();
                System.out.println("Update counts returned by exception:");
                for (int i : bue.getUpdateCounts()) {
                    System.out.println(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

    private static int[] doBatchUpdate(Connection conn) throws SQLException {
        int[] updateCounts = null;
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO table1 (id) VALUES (?)")) {
            ps.setInt(1, 1);
            ps.addBatch();
            ps.setInt(1, 2);
            ps.addBatch();
            ps.setInt(1, 3);
            ps.addBatch();
            updateCounts = ps.executeBatch();
        } catch (org.h2.jdbc.JdbcSQLException jse) {
            throw new BatchUpdateException(jse.getMessage(), updateCounts, jse);
        }
        return updateCounts;
    }

}