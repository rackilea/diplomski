@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Override
  @Bean
  public RequestMappingHandlerMapping requestMappingHandlerMapping() {
          RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
          handlerMapping.setOrder(-1);
          handlerMapping.setInterceptors(getInterceptors());
          return handlerMapping;
  }

}