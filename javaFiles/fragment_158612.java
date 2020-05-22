@Bean
public ReloadableResourceBundleMessageSource messageSource() {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    // other configurations
    messageSource.setBasenames("classpath:localization/messages");
    return messageSource;
}