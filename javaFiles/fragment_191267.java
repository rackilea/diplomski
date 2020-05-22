@Bean
public InternalResourceViewResolver resolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();

    resolver.setPrefix("/views/");
    resolver.setSuffix(".jsp");