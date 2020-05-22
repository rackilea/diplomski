@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebHomeConfig extends WebMvcConfigurerAdapter implements
    ApplicationContextAware {

  private ApplicationContext _appContext;


  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.context.ApplicationContextAware#setApplicationContext
   * (org.springframework.context.ApplicationContext)
   */
  @Override
  public void setApplicationContext(ApplicationContext appContext)
      throws BeansException {
    _appContext = appContext;
  }

  @Bean
  public ViewResolver getViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }


  /**
   * Since we don't have any controller logic, simpler to just define
   * controller for page using View Controller. Note: had to extend
   * WebMvcConfigurerAdapter to get this functionality
   * 
   * @param registry
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/about").setViewName("aboutUs");
    registry.addViewController("/privacy").setViewName("privacyPolicy");
  }
}