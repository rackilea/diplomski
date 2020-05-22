Properties jdbcProperties = new Properties();

this.jdbcProperties.put("user", userName);
this.jdbcProperties.put("password", password);
this.jdbcProperties.put("v$session.program", "YourApplicationName");
DriverManager.getConnection(url, jdbcProperties);