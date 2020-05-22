@Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**").allowedOrigins("http://localhost:8080")
                      .allowedMethods("PUT", "DELETE", "GET", "POST");
      }
    };
  }