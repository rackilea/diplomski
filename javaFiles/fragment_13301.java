@EnableWebMvcSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    ...

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService uds) throws Exception { 
      auth
        .userDetailsService(uds)
        .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public UserDetailsManager udm(DataSource dataSource) {
        JdbcUserDetailsManager udm = new JdbcUserDetailsManager();
        udm.setDataSource(dataSource);
        return udm;
    }
}

@Service
public class MyUserService {

    @Autowired
    UserDetailsManager udm; 

    public void createUser(...) {
        //use builder here...
        udm.createUser(new User(...));
    }
}