@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
   @Bean
   public LocaleChangeInterceptor localeChangeInterceptor() {
       LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
       lci.setParamName("lang");
       return lci;
   }

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(localeChangeInterceptor());
   }

   @Bean
   public AcceptHeaderLocaleResolver localeResolver(WebMvcProperties mvcProperties) {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver() {
            @Override
            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
                LocaleContextHolder.setLocale(locale);
            }
        };

        localeResolver.setDefaultLocale(mvcProperties.getLocale());
        return localeResolver;
    }
}