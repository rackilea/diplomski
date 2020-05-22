public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

@Override
    public void configure(HttpSecurity http) {
        JWTFilter customFilter = new JWTFilter();
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

}