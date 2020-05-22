// Initialize the global LogManager
public CustomLoggingPropertiesLoader() {
    try {
        LogManager.getLogManager().readConfiguration(CustomLoggingPropertiesLoader.class.getClassLoader().getResourceAsStream("logging.properties"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}