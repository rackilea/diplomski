public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        // configure filters
        http.addFilterBefore( new LDAPAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class );
        http.addFilterBefore( new OTPAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class );

        // configure authentication providers
        http.authenticationProvider( new LDAPAuthenticationProvider() );
        http.authenticationProvider( new OTPAuthenticationProvider() );

        // disable csrf
        http.csrf().disable();

        // setup security
        http.authorizeRequests()
            .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
    }
}