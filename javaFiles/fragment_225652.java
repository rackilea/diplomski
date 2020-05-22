public class DBConnection {

final private String url = "jdbc:mysql://localhost/";
final private String databaseName = "test";
final private String user = "root";
final private String password = "159753";

public Connection Connect() {
    Connection c = null;
    try {
        c = DriverManager.getConnection(url + databaseName, user, password);
    } catch (SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    return c;
}}