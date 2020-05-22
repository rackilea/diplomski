@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/css/**").addResourceLocations("/templates/css/");
}