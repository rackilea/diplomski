import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
public class MyCustomLdapAuthPopulator extends DefaultLdapAuthoritiesPopulator {

    @Autowired
    public MyCustomLdapAuthPopulator(ContextSource contextSource, String groupSearchBase) {
        super(contextSource, groupSearchBase);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Set<GrantedAuthority> getAdditionalRoles(DirContextOperations user, String username) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add((new SimpleGrantedAuthority("ROLE_XXX")));
        return authorities;
    }
}