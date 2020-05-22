@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter 
{

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
    {
    //If you want to store plain password you can use NoOpPasswordEncoder
    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password, enabled from userdetails where userName=?")
                .authoritiesByUsernameQuery(
                        "SELECT ud.username AS username, rm.name AS role FROM user_role_mapping map " + 
                        "INNER JOIN userdetails ud ON map.userId = ud.id " + 
                        "INNER JOIN rolemaster rm ON  map.roleId = rm.id  where userName = ?");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http
        .authorizeRequests()
            .antMatchers("/resources/**", "/", "/login", "/api/**").permitAll()
            .antMatchers("/config/**", "/app/admin/**")
                .hasRole("ADMIN")
            .antMatchers("/app/user/**")
            .hasAnyRole("ADMIN", "USER")
        .and().exceptionHandling().accessDeniedPage("/403")
        .and().formLogin()
            .loginPage("/login")
            .usernameParameter("userName").passwordParameter("password") 
            .defaultSuccessUrl("/app/user/dashboard")
            .failureUrl("/login?error=true")
        .and().logout()
            .logoutSuccessHandler(new CustomLogoutSuccessHandler())
            .invalidateHttpSession(true)
        .and()
            .csrf()
                .disable();

        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
    }

    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

}