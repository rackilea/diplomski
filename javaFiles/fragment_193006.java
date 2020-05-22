package persistence;

public class DatabaseUtils {
    private DatabaseUtils() {}

    public static Connection getConnection(String driver, String url, String username, String password) throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
}