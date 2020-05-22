@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/resources/**")
                        .addResourceLocations("/public", "classpath:/static/")
                        .setCachePeriod(31556926);
        }

}