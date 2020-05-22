@Order(23) // MED
@Configuration
public static class FormLoginConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/form/**").authorizeRequests().anyRequest().authenticated()
                .and().formLogin().permitAll().loginPage("/form/login").loginProcessingUrl("/form/login")
                .and().logout().logoutUrl("/form/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
    }
}

@Order(67) // LOWEST
@Configuration
public static class NoAuthConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // this ensures security context info (Principal, sec:authorize, etc.) is accessible on all paths
        http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
    }
}