@Override
public void addResourceHandlers(ResourceHandlerRegistry registry)
{
    registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("classpath:/static/");
}