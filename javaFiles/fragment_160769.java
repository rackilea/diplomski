private DataSource getDataSource (String dataSourceLocation) throws NamingException
  {
    // Get a context for the JNDI look up
    Context ctx = new InitialContext();
    Context envContext = (Context) ctx.lookup("java:/comp/env");

    // Look up a data source
    javax.sql.DataSource ds
      = (javax.sql.DataSource) envContext.lookup (dataSourceLocation); 

    return ds;
  }

  private Connection getConnection (DataSource ds) throws SQLException
  {
    Connection conn = null;
    // Get a connection object
    conn = ds.getConnection();

    return conn;
  }