@Bean
public LocaleResolver localeResolver(){
    SessionLocaleResolver r = new SessionLocaleResolver();
    r.setDefaultLocale(Locale.US);
    return r;
}