@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {
    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
        handlerMapping.setUseSuffixPatternMatch(false); // no prefix matches
        handlerMapping.setUseTrailingSlashMatch(false); // no affix matches
        return handlerMapping;
    }
}