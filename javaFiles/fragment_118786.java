public class Service {

    private static final Service INSTANCE = new Service();

    private static final ThreadLocal<TargetUrl> TARGET_URL_HOLDER = new ThreadLocal();

    private Service() {

    }

    public static Service getInstance() {
        return Service.INSTANCE;
    }

    public void start() {
        Settings initialConfiguration = Configuration.getSettings();
        TARGET_URL_HOLDER.set(initialConfiguration.getTargetUrl());
        // some more stuff before starting
    }

    public void reinitialize() {
        Settings updatedConfiguration = Configuration.getSettings();
        TARGET_URL_HOLDER.set(updatedConfiguration.getTargetUrl());
        .......
    }
}

public class Settings {
    private TargetUrl targetUrl;

    public TargetUrl getTargetUrl() {
        return this.targetUrl;
    }

    public void setTargetUrl(TargetUrl targetUrl) {
        this.targetUrl = targetUrl;
    }
}

public class Configuration {
    // use threadLocal to store the settings instance so it can be retrieved via a static method (e.g. getSettings)
    private static ThreadLocal<Settings> SETTINGS_HOLDER = new ThreadLocal<>();

    public void initialize() {

        // initialize the configuration
        Settings initialSettings = ..........
        SETTINGS_HOLDER.set(initialSettings);    
    }

    // Method to update configuration
    public void update() {
        // some method which will get the updated configuration value
       Settings updatedSettings = .............
       SETTINGS_HOLDER.set(updatedSettings);
    }

    //method to retrun configuration settings
    public static Settings getSettings() {
        return SETTINGS_HOLDER.get();
    }
}

public class Test {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.initialize();

        Service service = Service.getInstance();
        service.start();
        // use service instance
        ...................

        configuration.update();

        service.reinitialize();

        // keep using the service instance
       .................
    }
}