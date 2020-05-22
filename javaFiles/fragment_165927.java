@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
}

@Configuration
public class WebSecurityConfig {

    @Configuration
    @EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
    @ConditionalOnExpression("!${my.security.enabled:false}")
    protected static class DefaultWebSecurityConfig {
    }

    @Configuration
    @EnableAutoConfiguration
    @EnableWebMvcSecurity
    @Profile("local")
    @ConditionalOnExpression("${my.security.enabled:false}")
    protected static class LocalWebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated();
            http
                .formLogin().loginPage("/login").permitAll().and()
                .logout().permitAll();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");
        }
    }

}