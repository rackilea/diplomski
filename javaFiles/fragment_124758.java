@Configuration
@EnableResourceServer
public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/v1/register", "/api/v1/publicOne", "/api/v1/publicTwo").permitAll() //Allow urls
            .anyRequest().authenticated().and()
            .antMatcher("/api/**").authorizeRequests() //Authenticate all urls with this body /api/home, /api/gallery
            .antMatchers("/api/**").hasRole("ADMIN")
            .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler()); //This is optional if you want to handle exception
    }
}