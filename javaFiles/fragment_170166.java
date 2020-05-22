@ManagedBean(name="settings", eager=true)
@ApplicationScoped
public class SettingsManager extends HashMap<String, Object> {

    public SettingsManager() {
        put("PRODUCTION", Settings.PRODUCTION);
        put("DEBUG", Settings.DEBUG);
        put("HOSTNAME", Settings.HOSTNAME);
        // ...
    }

}