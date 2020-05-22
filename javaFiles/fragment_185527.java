@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!registry.hasMappingForPattern("/resources/**")) {
        registry.addResourceHandler("/resources/**").addResourceLocations(
            "classpath:/static/");
    }
}