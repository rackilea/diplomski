public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailSecurityService userDetailSecurityService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/ace/**",
                                                            "/app/**",
                                                            "/jquery/**",
                                                            "/bootstrap/**",
                                                            "/font-awesome/**",
                                                            "/jstree/**",
                                                            "/img/**").permitAll().anyRequest()
            .fullyAuthenticated();

        http.csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=1").permitAll().defaultSuccessUrl("/configurator").and().logout().permitAll();

        http.headers().frameOptions().disable().addHeaderWriter(new StaticHeadersWriter("X-FRAME-OPTIONS", "SAMEORIGIN"));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws  Exception {
        auth.userDetailsService(userDetailSecurityService).passwordEncoder(passwordEncoder());
    }


     @Bean
     public PasswordEncoder passwordEncoder(){
         return new MD5PasswordEncoder();
     }

}