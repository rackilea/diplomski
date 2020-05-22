import java.sql.*;

public class Main {
  public static void main(String[] args) throws Exception {
    System.setProperty("oracle.net.tns_admin", "C:/app/product/11.2.0/client_1/NETWORK/ADMIN");
    String dbURL = "jdbc:oracle:thin:@ENTRY_FROM_TNSNAMES";

    Class.forName ("oracle.jdbc.OracleDriver");

    Connection conn = null;
    Statement stmt = null;

    try {
      conn = DriverManager.getConnection(dbURL, "your_user_name", "your_password");

      System.out.println("Connection established");

      stmt = conn.createStatement();

      ResultSet rs = stmt.executeQuery("SELECT dummy FROM dual");

      if (rs.next()) {
        System.out.println(rs.getString(1));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (stmt != null) try { stmt.close(); } catch (Exception e) {}
      if (conn != null) try { conn.close(); } catch (Exception e) {}
    }
  }
}