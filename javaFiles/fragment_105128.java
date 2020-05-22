public class LdapUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
//Basically you need user details , username,password,roles you can fetch from your LdapService

        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        final SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        authorities.add(authority);

return new User(userName, "password", authorities);   }