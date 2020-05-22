@Override
protected void configure(HttpSecurity http) throws Exception {
http.cors().and().csrf().disable()
        // .. some settings
        .addFilter(new JWTAuthenticationFilter(authenticationManager(), getApplicationContext()))
        // some other settings    
}