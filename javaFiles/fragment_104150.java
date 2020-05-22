import java.sql.*;
import oracle.jdbc.OracleTypes;

public class Error17004Test {
    public static void main(String[] args) throws Exception {
        try (Connection c = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "user", "password")) {

            try (Statement stmt = c.createStatement()) {
                stmt.execute(
                    "CREATE OR REPLACE FUNCTION bool_test RETURN BOOLEAN " +
                    "AS BEGIN RETURN TRUE; END;");
            }

            try (CallableStatement cstmt = c.prepareCall("{ ? = call bool_test }")) {
                cstmt.registerOutParameter(1, OracleTypes.BOOLEAN);
                cstmt.execute();
                System.out.println("Got result of " + cstmt.getObject(1));
            }
        }
        catch (SQLException e) {
            System.out.println("Got a SQLException with message '" + e.getMessage() +
                    "' and error code " + e.getErrorCode());
        }
    }
}