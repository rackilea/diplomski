@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { ... }

    @Override
    protected void configure(HttpSecurity http) throws Exception { ... }
}