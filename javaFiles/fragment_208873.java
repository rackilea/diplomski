import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static Connection getConnection() throws Exception {
    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    String url = "jdbc:odbc:excelDB";
    String username = "yourName";
    String password = "yourPass";
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
}

public static void main(String args[]) throws Exception {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    conn = getConnection();
    stmt = conn.createStatement();
    String excelQuery = "select symptoms_1 from [Sheet1$]";
    rs = stmt.executeQuery(excelQuery);

    while (rs.next()) {
      //Fill the data for your drop-down list
    }

    rs.close();
    stmt.close();
    conn.close();
  }
}