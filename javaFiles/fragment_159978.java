@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    TosFilter rolesFilter;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .addFilterAfter(rolesFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll();
    }
}