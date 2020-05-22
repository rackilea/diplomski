import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcClient {
  private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

  public static void main(String[] args) throws SQLException {
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }
    Connection con = DriverManager.getConnection("jdbc:hive://YOUR_IP:YOUR_PORT/default", "", "");
    Statement stmt = con.createStatement();
    String sql;
    ResultSet res;



    sql = "SELECT * FROM keyspace.colFam WHERE name = 'John'";
    res = stmt.executeQuery(sql);
    while (res.next()) {
        System.out.println(res.getString("name"));
   }
 }
}