public class TestThis implements Listener{

    private EventsManager eventsManager;
    private ConfigManager configManager;

    public TestThis() {
        eventsManager = new EventsManager();
        configManager = new ConfigManager(this);
        eventsManager.addListener(this);
        configManager.load();
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public void configLoadedSuccessfully(Event event) {
        System.out.println(this.configManager);
        System.out.println(this.getConfigManager());
    }
}