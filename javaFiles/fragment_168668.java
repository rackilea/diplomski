@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource ();
        messageSource.setBasenames("classpath:messages", "classpath:messages2");
        return messageSource;
    }