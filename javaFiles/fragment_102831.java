@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(jwtuserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoderBean());
        return authenticationProvider;
    }