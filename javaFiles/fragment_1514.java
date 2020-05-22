public class AuthenticationProcessingFilterBeanPostProcessor implements
    BeanPostProcessor {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationProcessingFilterBeanPostProcessor.class);

  public Object postProcessAfterInitialization(Object bean, String beanName)
      throws BeansException {
    if ("_formLoginFilter".equals(beanName) && bean instanceof AuthenticationProcessingFilter) {
      AuthenticationProcessingFilter filter = (AuthenticationProcessingFilter) bean;
      WebAuthenticationDetailsSource source = (WebAuthenticationDetailsSource) filter.getAuthenticationDetailsSource();
      source.setClazz(CustomWebAuthenticationDetails.class);
    }
    return bean;
  }

  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @SuppressWarnings("serial")
  public static class CustomWebAuthenticationDetails extends
      WebAuthenticationDetails {
    private String customAttribute;//customfield
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
      super(request);
      //Build custom attributes that could be used elsewhere (say in DaoAuthenticationProvider ) 
      //with (CustomWebAuthenticationDetails)authentication.getDetails()
      customAttribute = request.getHeader("username");
    }
    public boolean getCustomAttribute() {
      return customAttribute;
    }
  }
}