MysqlDataSource ds = new MysqlDataSource();
ds.setDatabaseName("DATABASE");
ds.setUser("USERNAME");
ds.setPassword("USER PASSWORD");
ds.setServerName("localhost");
ds.setPort(3306);
connection = ds.getConnection();