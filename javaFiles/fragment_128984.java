public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final
    UserDetailsService service;

    @Autowired
    public WebSecurityConfig(UserDetailsService service) {
        this.service = service;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(service).passwordEncoder(passwordEncoder());

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //left out because not related here
    }
}