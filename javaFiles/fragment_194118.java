@Configuration
@EnableWebMvc
@ComponentScan({"com.seeds.controllers", "com.seeds.validators"})
public class WebConfig implements WebMvcConfigurer {

    //Message Source config
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/locales/message");
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(-1);
        return messageSource;
    }

    @Bean
    public SessionLocaleResolver localeResolver(){

        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("ru"));
        return localeResolver;
    }