@TestConfiguration
static class Config extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.authorizeRequests()
            .mvcMatchers( JsonAuthenticationFilter.AUTH_PASS ).permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable();
    }
}