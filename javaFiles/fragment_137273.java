@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {
    private static final String[] CLASS_PATH = {"classpath:/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASS_PATH);
    }
}