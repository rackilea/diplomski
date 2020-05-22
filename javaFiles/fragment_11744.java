BasicDataSource ds = new BasicDataSource();
ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
ds.setUsername("scott");
ds.setPassword("tiger");
ds.setValidationQuery("SELECT 1"); // this is database specific
ds.setTestWhileIdle(true); // test the connections every so often
ds.setUrl(connectURI);
...
while (!shutdown) {
    Connection conn = dataSource.getConnection();
    Statement stmt = conn.createStatement();
    ...
    stmt.close();
    // this returns the connection back to the pool instead of really closing
    // the connection
    conn.close();
}