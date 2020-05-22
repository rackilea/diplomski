@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**").permitAll().anyRequest()
                .fullyAuthenticated().and().formLogin();
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {              
            DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://<url>");
            contextSource.setUserDn("<username>");
            contextSource.setPassword("<password>");
            contextSource.setReferral("follow"); 
            contextSource.afterPropertiesSet();

            LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuthenticationProviderConfigurer = auth.ldapAuthentication();

            ldapAuthenticationProviderConfigurer
                .userSearchFilter("(&(cn={0}))")
                .userSearchBase("")
                .contextSource(contextSource);
        }
    }
}