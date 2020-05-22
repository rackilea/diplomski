/**
 * Update configuration.
 */
public void updateConfiguration() {
    Path path = configPath.resolve(LOG_FILE_NAME);
    if (Files.exists(path)){
        System.out.println(MessageFormat.format("Reloading logging configuration from {0}", path.toAbsolutePath()));
        PropertyConfigurator.configure(path.toAbsolutePath().toString());
    } else {
        System.err.println(MessageFormat.format("log4j.properties file was expected at {0} but was not present. Please create this file and configure it for logging to work.", path.toAbsolutePath()));
    }
}