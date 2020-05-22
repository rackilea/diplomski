@Bean
public CorsFilter corsFilter() {

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true); // you USUALLY want this
    // likely you should limit this to specific origins
    config.addAllowedOrigin("*"); 
    config.addAllowedHeader("*");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("PUT");
    source.registerCorsConfiguration("/logout", config);
    return new CorsFilter(source);
}