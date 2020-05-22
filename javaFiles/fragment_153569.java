@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("/resources/**")
        .addResourceLocations("/**")
        .resourceChain(true)
        .addResolver(
            new VersionResourceResolver().addContentVersionStrategy("/**"));
}