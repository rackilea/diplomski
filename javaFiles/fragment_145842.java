@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/**")
        .addResourceLocations("file:/var/www/websites/");
  }
}