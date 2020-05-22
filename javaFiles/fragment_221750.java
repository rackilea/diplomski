import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.CallableStatement;

public class Main2 {
  public static void main(String[] args) throws Exception {
    Connection conn = getOracleConnection();
    System.out.println("Got Connection.");

    CallableStatement callStmt = null;

    try {
      callStmt = conn.prepareCall("{? = call gettotal(?)}");
      callStmt.setInt(2, 1);
      callStmt.registerOutParameter(1, java.sql.Types.NUMERIC);
      callStmt.execute();

      System.out.println(callStmt.getInt(1));
    } finally {
      callStmt.close();
      conn.close();
     }
  }

  public static Connection getOracleConnection() throws Exception {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@HOST_ADDRESS:1521:orcl";
    String username = "USERNAME";
    String password = "PASSWORD";

    Class.forName(driver); // load Oracle driver

    java.util.Properties info = new java.util.Properties();  
    info.put ("user", "hr");  
    info.put ("password", "oracle");  
    Connection conn = DriverManager.getConnection(url, info);

    return conn;
  }
}