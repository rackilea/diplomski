Context initCtx = new InitialContext();
Context envCtx = (Context) initCtx.lookup("java:comp/env");
DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

Connection conn = ds.getConnection();
... use this connection to access the database ...
conn.close();