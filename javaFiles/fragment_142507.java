public class DatabaseConnectivity {
    public static Connection getConnection() throws NamingException, SQLException {
        InitialContext cxt = new InitialContext();
        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/ProjectX" );
        return ds.getConnection();
    }
}