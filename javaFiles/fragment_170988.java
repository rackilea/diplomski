@RequestScoped
public class ConfigParameterProvider {

    @Inject
    private ConfigParameterDao configParameterDao;

    private Map<String, String> configParameters = new HashMap<>();

    @PostConstruct
    public void init() {
        List<ConfigParameter> configParams = configParameterDao.findAll();
        configParameters = configParams.stream()
            .collect(toMap(ConfigParameter::getId, ConfigParameter::getValue));
    }

    public String getProperty(String key) {
        return configParameters.get(key);
    }

}