@Bean
public ViewResolver getViewResolver() {

    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
    resolver.setCache(false);
    //  resolver.setPrefix("");
    resolver.setSuffix(".ftl");

    return resolver;

}