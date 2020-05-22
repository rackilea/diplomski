Connection con;
 try {
 con = ...; // open connection    
catch (SQLException e) {
// do stuff with your connection
 } finally {
 if (con != null && !con.isClosed()) {
    try {
        con.close();
    catch (SQLException e) {
        log.error("Failed to close connection", e);
    }
  }
}