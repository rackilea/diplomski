@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    // other stuffs

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/protected/**").addResourceLocations("classpath:/resources/");
    }
}