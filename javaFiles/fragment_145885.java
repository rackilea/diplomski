private static Properties DEFAULT_PROPERTIES = getDefaultProperties();

private static Properties getDefaultProperties() {
    Properties properties = new Properties();
    try {
        properties.load(MyClass.class.getResourceAsStream("myclass.properties"));
    } catch (IOException e) {
        throw new ConfigurationException("Cannot load properties file", e);
    }
    return properties;
}