FileInputStream fis = new FileInputStream("config.properties");
Properties dbProperties = new Properties();
dbProperties.load(fis);
String host = dbProperties.getProperty("db.host");
String login = dbProperties.getProperty("db.login");
String password = dbProperties.getProperty("db.password");