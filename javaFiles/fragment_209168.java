PGSimpleDataSource pgDataSource = new PGSimpleDataSource();
pgDataSource.setDataSourceName("Acme Corp invoicing database");
pgDataSource.setServerName("localhost");
pgDataSource.setDatabaseName("test");
pgDataSource.setUser("testuser");
pgDataSource.setPassword("testpassword");

DataSource dataSource = pgDataSource ;  // Perhaps save as an "attribute" on your web app's "context".