public class DBUtil {

private static DataSource dataSource;

static {
    try {
        dataSource = new InitialContext().lookup("jdbc/MyDataSource");
    } catch (NamingException e) { 
        throw new ExceptionInInitializerError("'jdbc/MyDataSource' not found in JNDI", e);
    }
}

public static Connection getConnection() {
    return dataSource.getConnection();
}