public class Configuration {
    private String mode;
    private Properties properties;

    public Configuration(String mode, Properties properties) {
        this.mode = mode;
        this.properties = properties;
    }

    public String get(String key) {
        return properties.getString(mode + "." + key);
    }
}