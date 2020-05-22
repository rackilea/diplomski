@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // other stuffs

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/public/**").permitAll()
                    .antMatchers("/protected/**").authenticated()
                    .anyRequest().authenticated();
    }
}