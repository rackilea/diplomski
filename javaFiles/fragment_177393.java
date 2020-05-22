Properties properties = new Properties();
ClassLoader loader = Thread.currentThread().getContextClassLoader();
InputStream stream = loader.getResourceAsStream("properties/app.properties");
try {
    properties.load(stream);
} catch (IOException | NullPointerException e) {
    WebOptionPane.showMessageDialog(null, "Couldn't read app.properties", "Fehler",
                                    WebOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
    return;
}
name = properties.getProperty("username");