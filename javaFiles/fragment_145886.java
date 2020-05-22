private static Properties DEFAULT_PROPERTIES = SomeUtil.getProperties("myclass.properties");

// Put this in a SomeUtil class.
public static Properties getProperties(String filename) {
    Properties properties = new Properties();
    try {
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
    } catch (IOException e) {
        throw new ConfigurationException("Cannot load " + filename, e);
    }
    return properties;
}