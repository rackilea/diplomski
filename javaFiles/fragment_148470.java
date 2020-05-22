public class DBConnection implements AutoCloseable {
    private String url = ...
    private Connection con;
    private Statement statement;

    public DBConnection () throws SQLException {
        try {
             con = DriverManager.getConnection(url);
             statement = con.createStatement();
        } finally {
             // Avoid leak if an exception was thrown in createStatement
             if (statement == null) {
                 con.close();
             }
        }
    }

    public void addSubject(String subject) throws SQLException {
        statement.executeUpdate("INSERT INTO `Subject` VALUES ('" + 
                                subject + "')" );
    }

    public void close() throws SQLException {
        con.close();
    }
}