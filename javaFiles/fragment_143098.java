@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();

    config.setAllowedOrigins(Arrays.asList("*"));
    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); -- Define which methods are allowed to pre-flight
    config.setAllowedHeaders(Arrays.asList("my-allowed-headers"));
    config.setExposedHeaders(Arrays.asList("my-exposed-headers"));

    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    configSource.registerCorsConfiguration("/**", config);

    return configSource;
}