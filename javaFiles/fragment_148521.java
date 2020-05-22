@Bean
JsonAuthenticationFilter authenticationFilter() {
    JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
    // .. other configs
    filter.setAuthenticationSuccessHandler(new RestAuthenticationSuccessHandler());
    filter.setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
}