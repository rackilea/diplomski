// Look up the connection pool data source
javax.naming.InitialContext ctx = new javax.naming.InitialContext();
javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup("Your JNDI Name here");

// Get a database connection
java.sql.Connection conn = ds.getConnection();
try {
  // Do something with the connection
} finally {
  // Close connection so it can be released back to the pool!
  conn.close();
}