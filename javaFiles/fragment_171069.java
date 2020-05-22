public class ConnectionManager {

private Connection connection;
public String driverURL = "[Your driver URL]";

    public Connection getConnection(String user, String password) {
    try {
        //SQLServerDriver or whichever you are using
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(driverURL, username, password);
    }catch(ClassNotFoundException e) {
        e.printStackTrace();
    }
    catch(SQLException e) {
        e.printStackTrace();
    }
    return connection;
}