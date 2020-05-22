@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        boolean abilitaCors = new Boolean(env.getProperty("templating.oauth.enable.cors"));
        if( abilitaCors )
        {
            if( logger.isWarnEnabled() )
            {
                logger.warn("CORS ABILITATI! Si assume ambiente di sviluppo");
            }
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:8080", "http://localhost:8180"));
            configuration.setAllowedMethods(Arrays.asList(  RequestMethod.GET.name(),
                    RequestMethod.POST.name(), 
                    RequestMethod.OPTIONS.name(), 
                    RequestMethod.DELETE.name(),
                    RequestMethod.PUT.name()));
            configuration.setExposedHeaders(Arrays.asList("x-auth-token", "x-requested-with", "x-xsrf-token"));
            configuration.setAllowedHeaders(Arrays.asList("X-Auth-Token","x-auth-token", "x-requested-with", "x-xsrf-token"));
            source.registerCorsConfiguration("/**", configuration);
        }
        return source;
    }