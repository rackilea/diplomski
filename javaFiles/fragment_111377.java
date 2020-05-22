Properties properties = new Properties();
properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"))

DataSource dataSource = new PGSimpleDataSource();
dataSource.setServerName(properties.get("database.server.name")); 
...