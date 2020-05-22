@Configuration
@ConfigurationProperties(prefix = "secret")
class SecuredProperties {

    private String user;
    private String password;

    // getters and setters
}


@Configuration
@EnableWebFluxSecurity
class SecurityConfig {
    private SecuredProperties securedProperties;

    SecurityConfig(SecuredProperties securedProperties){
        this.securedProperties = securedProperties;
    }
    .....
    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username(securedProperties.getUser())      // <---
                .password(securedProperties.getPassword())  // <---
                .roles("INTERNAL_APP")
                .build();
        return new MapReactiveUserDetailsService(user);
    }