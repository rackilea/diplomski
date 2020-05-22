@Override 
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
            .authorizeRequests().antMatchers("/assets/**").permitAll()
         .and()
            .httpBasic().disable()
            .formLogin().disable()
            .logout()
            .logoutSuccessHandler((new CustomLogoutSuccessHandler(applicationProperties)))
            .deleteCookies("JSESSIONID")
         .and()
            .addFilter(new TokenBasedAuthenticationFilter(authenticationManager(), applicationProperties, commonProperties.getAuthTokenSecret()))
            .addFilter(new TokenBasedAuthorizationFilter(authenticationManager(), applicationProperties, commonProperties.getAuthTokenSecret()));

 }