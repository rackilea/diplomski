import java.sql.*;
import java.io.*;

public class BeerBeer {
  // Edit to return ResultSet
  public static String getBreweryInfo (int Raz_ID) 
  throws SQLException 
  { 
    String sql = 
      "SELECT Nosaukums FROM Alus_razotaji WHERE ID = ?";//vaicajums
    String toReturn = "";
    try {
      Connection conn = DriverManager.getConnection("jdbc:default:connection:");
      PreparedStatement apstmt = conn.prepareStatement(sql);
      apstmt.setInt(1, Raz_ID); 
      ResultSet rset = apstmt.executeQuery();// SQL vaicājuma izpildīšana
      if (rset.next()) {
          toReturn = rset.getString(1);
          rset.close();
          apstmt.close();
          return toReturn;
      }else{
          return toReturn;
      } 
    }
    catch (SQLException e) {
      System.err.println(e.getMessage()); //Kļūdu izvadīsana
      toReturn = "Exx";
      return toReturn;
    } 
  }
}