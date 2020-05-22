@ManagedBean
@ApplicationScoped
public class PropertiesHolder {

    private static final String PATH = "~/Desktop/propertiesRepo/example.properties";
    private Properties properties;
    private ScheduledExecutorService scheduler;

    @PostConstruct
    public void init() {
        properties = new Properties();
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    properties.load(new FileInputStream(PATH));
                } catch (IOException e) {
                    throw new RuntimeException("Failed to load properties", e);
                }
            }
        }, 0L, 2L, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void destroy() {
        scheduler.shutdownNow();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}