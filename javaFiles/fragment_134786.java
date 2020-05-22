@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    DatabasePersistentTokeRepositoryImpl databasePersistentTokeRepositoryImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {      
        http
        .rememberMe()
            .key("KEY")
            .tokenRepository(databasePersistentTokeRepositoryImpl)
                .tokenValiditySeconds((int) TimeUnit.SECONDS.convert(7, TimeUnit.DAYS))
        .and()
            .csrf().disable();
    }
}