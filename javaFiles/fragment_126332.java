import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;

import java.sql.*;

public class TriggerPerformanceTest {
    private static final int STEPS_COUNT = 1000;

    public static void main(String[] args) throws SQLException {
        final Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@host:1521/oradev", "user", "pass");

        prepare(connection);

        final StopWatch stopWatch = new StopWatch("mini-bench");

        testTrigger(connection, stopWatch);
        testSequence(connection, stopWatch);
        testSeparateCalls(connection, stopWatch);

        JdbcUtils.closeConnection(connection);

        System.out.println(stopWatch.prettyPrint());
    }

    private static void testTrigger(Connection connection, StopWatch stopWatch) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test_table_trigger (text) VALUES (?)", new String[]{"ID"});
        stopWatch.start("with trigger");
        for (int i = 0; i < STEPS_COUNT; i++) {
            preparedStatement.setString(1, "test");
            preparedStatement.executeUpdate();

            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            final boolean next = resultSet.next();
            Assert.state(next, "Expected not empty result set with generated keys");
            final long id = resultSet.getLong(1);
            Assert.state(id > 0, "Expected generated key value");
            JdbcUtils.closeResultSet(resultSet);
        }
        stopWatch.stop();
        JdbcUtils.closeStatement(preparedStatement);
    }

    private static void testSequence(Connection connection, StopWatch stopWatch) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test_table_sequence (id, text) VALUES (sq_test2.NEXTVAL, ?)", new String[]{"ID"});
        stopWatch.start("without trigger");
        for (int i = 0; i < STEPS_COUNT; i++) {
            preparedStatement.setString(1, "test");
            preparedStatement.executeUpdate();

            final ResultSet resultSet = preparedStatement.getGeneratedKeys();
            final boolean next = resultSet.next();
            Assert.state(next, "Expected not empty result set with generated keys");
            final long id = resultSet.getLong(1);
            Assert.state(id > 0, "Expected generated key value");
            JdbcUtils.closeResultSet(resultSet);
        }
        stopWatch.stop();
        JdbcUtils.closeStatement(preparedStatement);
    }

    private static void testSeparateCalls(Connection connection, StopWatch stopWatch) throws SQLException {
        final PreparedStatement preparedStatementSeq = connection.prepareStatement("SELECT sq_test3.NEXTVAL FROM dual");
        final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test_table_generated (id, text) VALUES (?, ?)");

        stopWatch.start("separate calls");
        for (int i = 0; i < STEPS_COUNT; i++) {
            final ResultSet resultSet = preparedStatementSeq.executeQuery();
            resultSet.next();
            final long id = resultSet.getLong(1);
            JdbcUtils.closeResultSet(resultSet);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, "test");
            preparedStatement.executeUpdate();
        }
        stopWatch.stop();
        JdbcUtils.closeStatement(preparedStatementSeq);
        JdbcUtils.closeStatement(preparedStatement);
    }

    private static void prepare(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            statement.execute("DROP TABLE test_table_sequence");
            statement.execute("DROP TABLE test_table_trigger");
            statement.execute("DROP TABLE test_table_generated");
            statement.execute("DROP SEQUENCE sq_test1");
            statement.execute("DROP SEQUENCE sq_test2");
            statement.execute("DROP SEQUENCE sq_test3");
        } catch (SQLException sqle) {
            //ignore
        }

        try {
            statement.execute("CREATE TABLE test_table_sequence (id NUMBER, text VARCHAR2(10))");
            statement.execute("CREATE TABLE test_table_trigger (id NUMBER, text VARCHAR2(10))");
            statement.execute("CREATE TABLE test_table_generated (id NUMBER, text VARCHAR2(10))");
            statement.execute("CREATE SEQUENCE sq_test1 START WITH 1 INCREMENT BY 1 CACHE 20");
            statement.execute("CREATE SEQUENCE sq_test2 START WITH 1 INCREMENT BY 1 CACHE 20");
            statement.execute("CREATE SEQUENCE sq_test3 START WITH 1 INCREMENT BY 1 CACHE 20");
            statement.execute("CREATE OR REPLACE TRIGGER trg_increment BEFORE INSERT ON test_table_trigger FOR EACH ROW\n" +
                              "BEGIN\n" +
                              "  SELECT sq_test1.NEXTVAL INTO :new.id FROM dual;\n" +
                              "END;");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        try {
            statement.execute("TRUNCATE TABLE test_table_sequence");
            statement.execute("TRUNCATE TABLE test_table_trigger");
            statement.execute("TRUNCATE TABLE test_table_generated");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}