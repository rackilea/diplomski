ComboPooledDataSource cpds = new ComboPooledDataSource();
cpds.setDriverClass("com.mysql.jdbc.Driver");
cpds.setJdbcUrl("jdbc:mysql://localhost:3306/site_a");
cpds.setUser(user);
cpds.setPassword(pass);
....
Connection conn = getPool().getConnection();
conn.setCatalog("site_b");
...