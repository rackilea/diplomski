private String getRootKey() {
    Properties prop = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader();           
    InputStream stream = loader.getResourceAsStream("application.properties");
    String key=null;
    try {
        prop.load(stream);
        key = prop.getProperty("rootKey");
    } catch  (Exception e) {
        throw new RuntimeException("Cannot load webapprootkey", e);
    }
    return key;
}