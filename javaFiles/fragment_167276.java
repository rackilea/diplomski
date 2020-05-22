String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
String appConfigPath = rootPath + "application.properties";

Properties appProps = new Properties();
appProps.load(new FileInputStream(appConfigPath));

String appVersion = appProps.getProperty("version");