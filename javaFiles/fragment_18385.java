public class Settings {

    private static Settings instance;

    public static Settings initialise(Properties settings) {
        instance = new Settings(settings);
        return instance;
    }

    public static Settings get() {
        return instance;
    }

    private final Properties settings;

    private Settings(Properties settings) {
        this.settings = settings;
    }

    public String getProperty(String key) {
        return settings.getProperty(key);
    }
}