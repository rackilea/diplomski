@Bean
CorsWebFilter corsWebFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(Arrays.asList("http://allowed-origin.com"));
    corsConfig.setMaxAge(8000L);
    corsConfig.addAllowedMethod("PUT");
    corsConfig.addAllowedHeader("Baeldung-Allowed");

    UrlBasedCorsConfigurationSource source =
  new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return new CorsWebFilter(source);
}