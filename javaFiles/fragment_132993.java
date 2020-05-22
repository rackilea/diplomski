//no need to extend from this class
public final class ConnectionProvider {
    private static final String DEFAULT_DS = "jdbc/myDB";
    //no need to initialize this class
    private ConnectionProvider() {
    }
    //retrieve the connection
    public static Connection getConnection() {
        Connection con = null;
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup(DEFAULT_DS);
            con = dataSource.getConnection();
        } catch (Exception e) {
            //handle exception
            //basic handling, you should at least use a logger
            e.printStackTrace();
        }
        return con;
    }
}