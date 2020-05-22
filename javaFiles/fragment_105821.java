Connection conn = null;
Statement stmt = null'
ResultSet rs = null;
try {
  conn = getConnection();
  stmt = conn.prepareStatement(sql);
  stmt.setString(1, "Hello"); 
  rs = stmt.executeQuery();
  while (rs.next()) {
    // ...
  }
} catch (SQLException se) {
  se.printStackTrace();
} finally {
  if (rs != null) {
    try {
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  if (stmt != null) {
    try {
      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  if (conn != null) {
    try {
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}