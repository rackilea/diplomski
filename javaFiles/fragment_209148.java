Map<String, String> properties = new HashMap<String, String>();
properties.put(JDBC_DRIVER, this.jdbcDriver);
properties.put(JDBC_URL, this.url);
properties.put(JDBC_USER, this.username);
properties.put(JDBC_PASSWORD, this.password);

// Configure logging. FINE ensures all SQL is shown
properties.put(LOGGING_LEVEL, "FINE");  
return properties;