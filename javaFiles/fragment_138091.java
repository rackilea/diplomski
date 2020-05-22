Statement stmt = null;
ResultSet rs = null;
Connection conn = getConnection();
try {
  stmt = conn.createStatement();
  rs = stmt.executeQuery(sqlQuery);
  processResults(rs);
} catch (SQLException e) {
  // Forward to handler
} finally {
  try {
    if (rs != null) {rs.close();}
  } catch (SQLException e) {
    // Forward to handler
  } finally {
    try {
      if (stmt != null) {stmt.close();}
    } catch (SQLException e) {
      // Forward to handler
    } finally {
      try {
        if (conn != null) {conn.close();}
      } catch (SQLException e) {
        // Forward to handler
      }
    }
  }
}