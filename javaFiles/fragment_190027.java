@Configuration
@EnableWebSecurity
public class WebSecurityConfig
{

    @Autowired
    MyDBAuthenticationService myDBAuthenticationService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(myDBAuthenticationService);
    }

    @Configuration
    @Order(1)
    public static class WebConfigurationAdapter1 extends WebSecurityConfigurerAdapter
    {

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                    //.authorizeRequests().antMatchers("/am/**").access("hasRole('ROLE_AM')")
                    .antMatcher("/am/**").authorizeRequests().anyRequest().hasRole("AM")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")

                    .and()
                    .formLogin()
                    .loginPage("/amLogin")
                    .loginProcessingUrl("/am/postLogin")
                    .defaultSuccessUrl("/am/chatPage")
                    .failureUrl("/amLogin?error")
                    .and().logout().logoutUrl("/am/logout").logoutSuccessUrl("/amLogoutSuccessful")
                    .deleteCookies("JSESSIONID")
                    .and().csrf().disable();

            System.out.println("1st Configurer");
        }
    }

    @Configuration
    @Order(2)
    public static class WebConfigurationAdapter2 extends WebSecurityConfigurerAdapter
    {

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                    //.authorizeRequests().antMatchers("/customer/**").access("hasRole('ROLE_CUSTOMER')")
            .antMatcher("/admin/**").authorizeRequests().anyRequest().hasRole("CUSTOMER")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")

                    .and()
                    .formLogin()
                    .loginPage("/customerLogin")
                    .loginProcessingUrl("/customer/postLogin")
                    .defaultSuccessUrl("/customer/chatPage")
                    .failureUrl("/customerLogin?error")
                    .and().logout().logoutUrl("/customer/logout").logoutSuccessUrl("/customerLogoutSuccessful")
                    .and().csrf().disable();

            System.out.println("2nd Configurer");
        }
    }
}