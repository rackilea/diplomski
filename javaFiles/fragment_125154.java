String propertiesFileName = "/common.properties";

Properties properties = new Properties();
InputStream inputStream = this.getClass().getClassLoader()
    .getResourceAsStream(propertiesFileName);

properties.load(inputStream);