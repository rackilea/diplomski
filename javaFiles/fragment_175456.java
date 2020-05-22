@EnableResourceServer
public static class SecurityConfig extends ResourceServerConfigurerAdapter implements JwtAccessTokenConverterConfigurer {
// snip
        @Override
        public void configure(final HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.authorizeRequests().anyRequest().permitAll();
        }
// snip