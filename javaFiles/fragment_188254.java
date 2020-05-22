@ManagedBean
@ViewScoped
public class Admin {

    private Map<String, String> settings;

    @EJB
    private SettingsService service;

    @PostConstruct
    public void init() {
        settings = service.getAll();
    }

    public void save() {
        service.update(settings);
    }

    public Map<String, String> getSettings() {
        return settings;
    }

}