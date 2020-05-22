@Bean
public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath:/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
}