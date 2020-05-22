@Bean(name = "messageSource")
public ReloadableResourceBundleMessageSource validationMessageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:global");
    ...
    return messageSource;
}