Statement stmt;
try {
   stmt = con.createStatement();
   // do something with the statement
} catch (SQLException e) {
   LOG.error("SQL error", e);
} finally {
   try { if (stmt != null) stmt.close(); } catch (SQLException se) { LOG.error("Error closing the statement", se); }
   // if using Apache utils you could do
   // IOUtils.closeQuietly(stmt);
}