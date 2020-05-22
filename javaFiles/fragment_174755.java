@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Configuration
    @Order(1)
    public static class WebConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatchers("/web")
            ...
           /* Your previous config would go here */
        }
    }

    @Configuration
    @Order(2)
    public static class ApiConfiguration extends WebSecurityConfigurerAdapter {


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatchers("/web")

            ... /* Your /api configuration goes here */

                .exceptionHandling()
                  .authenticationEntryPoint(customAuthenticationEntryPoint)

        }

        @Bean
        AuthenticationEntryPoint customAuthenticationEntryPoint() {
            return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
        }
    }
}