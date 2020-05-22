Properties props = new Properties();
props.setProperty("user", "dbuser");
props.setProperty("password", "dbpassword");
props.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT, "2000");

Connection con = DriverManager.getConnection("<JDBC connection string>", props);