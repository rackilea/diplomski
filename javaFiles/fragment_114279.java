@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public EnrollCashRepository enrollCashRepository;

    @Override
    public void configure(WebSecurity webSecurity) throws Exception
    {
        webSecurity.ignoring().antMatchers(HttpMethod.GET, "/health");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http.addFilterBefore(tokenAuthorizationFilter(), BasicAuthenticationFilter.class);  
        http.authorizeRequests().antMatchers("/api/**").authenticated();    
    }

    private TokenAuthorizationFilter tokenAuthorizationFilter() 
    {
        return new TokenAuthorizationFilter(enrollCashRepository);
    }
}