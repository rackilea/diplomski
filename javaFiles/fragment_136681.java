@Configuration
public class AppConfig {

  @Primary
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public Tenant prototypeBean(RequestScopeTenant requestScopeTenant, DefaultTenant defaultTenant) {
      return RequestContextHolder.getRequestAttributes() != null ? requestScopeTenant : defaultTenant;
  }

  @Bean
  public MySingletonBean singletonBean() {
      return new MySingletonBean();
  }