@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Autowired private Environment environment;

  @Bean
  public PasswordEncoder encoder() {
     return new BCryptPasswordEncoder();
  }

  ....

  @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username(environment.getProperty("secret.user"))     // <----  
                .password(environment.getProperty("secret.password")) // <----
                .roles("INTERNAL_APP")
                .build();
        return new MapReactiveUserDetailsService(user);
    }
}