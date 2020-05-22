@Configuration
@EnableWebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/3.22.0/");
    }

    //this method was introduced just for convenient swagger ui access. Without it swagger ui can be accessed with /index.html GET call   
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui.html").setViewName("forward:/index.html");
    }
}