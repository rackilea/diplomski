@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
       http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .authorizeRequests()
                .antMatchers("/ajax/**").authenticated()           
                .antMatchers("/actuator/**").hasRole("ADMIN")  
                .anyRequest().authenticated()  
                .and()
            .csrf()
                .disable();
    }
}