@Configuration
public class LanguageConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public LocaleResolver localeResolver() {
        SmartLocaleResolver slr = new SmartLocaleResolver();
    Locale locale = new Locale("en", "us");
    slr.setDefaultLocale(locale); // Set default Locale as en_cos
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
    }

    class SmartLocaleResolver extends CookieLocaleResolver {

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String acceptLanguage = request.getHeader("Accept-Language");
            if (acceptLanguage == null || acceptLanguage.trim().isEmpty()) {
                return super.determineDefaultLocale(request);
            }
            return request.getLocale();
        }

    }
}