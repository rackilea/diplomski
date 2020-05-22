@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EntityScan(basePackages = { "persistence.mysql.domain" })
@EnableJpaRepositories("persistence.mysql.dao")
@EnableMongoRepositories("persistence.mongodb.dao")
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
value = ApiAuthenticationFilter.class) },
basePackages = {
                "admin",
                "common",
                "mqclient",
"scheduler" })
public class Application {

  @Value("${service.name}")
  private String serviceName;
  @Value("${service.namespace}")
  private String serviceNamespace;
  @Value("${webservice.namespace}")
  private String webserviceNamespace;
  @Value("${webservice.port}")
  private int webservicePort;
  @Value("${jersey.request-filters}")
  private String requestFilters;
  @Value("${jersey.response-filters}")
  private String responseFilters;

  private static final String MAPPING_URL = "/%s/*";

  static {
    System.setProperty(USER_TIMEZONE, "UTC");
  }

  /**
   * Java main method.
   */
  public static void main(String[] args) {
    /*
     * Defines which Spring Boot Profiles should be active on startup. Please see
     * http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-profiles for details.
     */
    final SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(Application.class);
    appBuilder.profiles("common", "common_mongo_db", "common_mysql_db", "common_rabbitmq", "admin").application()
    .run(args);
  }

  /**
   * Registers Jersey with Spring Boot.
   */
  @Bean
  public ServletRegistrationBean registerJersey() {
    final ServletRegistrationBean registration = new ServletRegistrationBean(new SpringServlet(),
                                                                             String.format(MAPPING_URL,
                                                                                           this.serviceNamespace));

    registration.addInitParameter(JERSEY_MAPPING_FEATURE, Boolean.toString(true));
    registration.addInitParameter(PROPERTY_CONTAINER_REQUEST_FILTERS, this.requestFilters);
    registration.addInitParameter(PROPERTY_CONTAINER_RESPONSE_FILTERS, this.responseFilters);
    registration.addInitParameter(PROPERTY_RESOURCE_FILTER_FACTORIES, ValidationResourceFilterFactory.class.getName());

    return registration;
  }

  /**
   * This method initializes SimpleHttpServerJaxWsServiceExporter bean which reads all @Webservice annotated components
   * and hosts web service for them.
   *
   * @return SimpleHttpServerJaxWsServiceExporter
   */
  @Bean
  public SimpleHttpServerJaxWsServiceExporter exportJaxwsService() {
    final SimpleHttpServerJaxWsServiceExporter jaxWsServiceExporter = new SimpleHttpServerJaxWsServiceExporter();
    jaxWsServiceExporter.setPort(this.webservicePort);
    jaxWsServiceExporter.setBasePath("/" + this.serviceNamespace + "/" + this.webserviceNamespace + "/");
    return jaxWsServiceExporter;
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.setTomcatContextCustomizers(Arrays.asList(new CustomCustomizer()));
    return factory;
  }

  static class CustomCustomizer implements TomcatContextCustomizer {

    @Override
    public void customize(Context context) {
      context.setUseHttpOnly(false);
      context.setCookies(false);
    }
  }
}