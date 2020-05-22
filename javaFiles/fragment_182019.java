import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
  public static void main(String[] argv) throws Exception {
    String driverName = "org.gjt.mm.mysql.Driver";
    Class.forName(driverName);

    String serverName = "localhost";
    String mydatabase = "mydatabase";
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 

    String username = "username";
    String password = "password";
    Connection connection = DriverManager.getConnection(url, username, password);
  }
}