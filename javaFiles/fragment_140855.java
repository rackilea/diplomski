@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private AuthenticationProvider authenticationProvider;

    @Value("${user.name}") 
    private String userName;

    @Value("${user.password}") 
    private String userHashedPassword; // hashed password

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
            .and().sessionManagement().and().authenticationProvider(authenticationProvider)
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
           .inMemoryAuthentication()
           .passwordEncoder(passwordEncoder())
           .withUser(userName)
           .password(userHashedPassword);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}