@Bean
public WebMvcConfigurer corsConfigurer() {
  return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                            .allowedOrigins("http://localhost:8888")
                            .addAllowedMethod(HttpMethod.DELETE);
            }
        };
    }