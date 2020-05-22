//Leave whatever you had here
@Override
public void configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(new TokenAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class);

    String contentPathDir = String.format("/%s/**", contentPath);

    http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests()
            .antMatchers("/authorization/**", "/public/**", "/management/**", "/health/**", contentPathDir).permitAll()
            .antMatchers("/**").authenticated();
}




//Add these two below. 
@Override
public void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(apiKeyAuthenticationProvider());
}

@Bean
public TokenAuthenticationProvider apiKeyAuthenticationProvider() {
    return new TokenAuthenticationProvider(apiKey);
}