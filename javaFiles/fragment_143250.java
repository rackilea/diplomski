Properties config = new Properties();
config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));

String url = config.getProperty("url");
String username = config.getProperty("username");
String password = config.getProperty("password");
// ...