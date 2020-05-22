@Component
public class TenantProperties {

  private Map<String, ConfigurableEnvironment> customEnvs;

  @Inject
  public TenantProperties(@Autowired ConfigurableEnvironment defaultEnv,
      @Value("${my.tenant.names}") List<String> tenantNames) {

    this.customEnvs = tenantNames
        .stream()
        .collect(Collectors.toMap(
            Function.identity(),
            tenantId -> {
              ConfigurableEnvironment customEnv = new StandardEnvironment();
              customEnv.merge(defaultEnv);
              Resource resource = new ClassPathResource(tenantId + ".properties");

              try {
                Properties props = PropertiesLoaderUtils.loadProperties(resource);
                customEnv.getPropertySources()
                    .addLast(new PropertiesPropertySource(tenantId, props));
                return customEnv;
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            }));
  }

  public String getProperty(String tenantId, String propertyName) {

    ConfigurableEnvironment ce = this.customEnvs.get(tenantId);
    if (ce == null) {
      throw new IllegalArgumentException("Invalid tenant");
    }

    return ce.getProperty(propertyName);
  }
}