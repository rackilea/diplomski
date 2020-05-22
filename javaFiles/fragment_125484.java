private void executeSql(String sql, ResultSetHandler handler) {
  Statement stmt = null;
  ResultSet rstmt = null;
  try {
    stmt = conn.createStatement();
    rstmt = stmt.executeQuery(sql);
    while (rstmt.next()) {
      handler.handle(rstmt);
    }
  }
  catch (SQLException e) {
    //handle errors
  }
  finally {
    try {rstmt.close();} catch (SQLException ex) {}
    try {stmt.close();} catch (SQLException ex) {}
  }
}