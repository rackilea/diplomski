@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("index.html").addResourceLocations("/index.html    ");
}

@Bean
public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setSuffix(".html");
    return viewResolver;
}