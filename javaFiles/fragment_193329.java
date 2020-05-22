@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                // Do you database query here
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_"));  // list of roles from database 
                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                           authentication.getCredentials(), authorities);
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return true;
            }
        })
    }
}