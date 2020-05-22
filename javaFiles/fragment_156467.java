@Configuration
public class CacheConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**")
        .addResourceLocations("/resources/")
        .setCachePeriod(3600);
    }
}