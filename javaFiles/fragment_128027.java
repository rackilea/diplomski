@Configuration
    public class SwaggerConfiguration implements WebMvcConfigurer {

      private final String swaggerUILocation = "whatEverLocationYouWant";
      private final String swaggerApiDocsLocation = "whatEverLocationYouWant";

      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(swaggerUILocation + "**")
            .addResourceLocations("classpath:/swagger-ui/");
        registry.addResourceHandler(swaggerApiDocsLocation + "**")
            .addResourceLocations("classpath:/swagger/");
      }
    }