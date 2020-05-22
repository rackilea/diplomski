@Configuration
    public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            IpAuthenticationProvider provider = new IpAuthenticationProvider();
            provider.setDelegate(authenticationProvider())
            auth.authenticationProvider(provider);
        }

        @Bean
        public AuthenticationProvider authenticationProvider() {

            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(userDetailsServiceBean());
            provider.setPasswordEncoder(passwordEncoder());
            return provider;
        }
    }