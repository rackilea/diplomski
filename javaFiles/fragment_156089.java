public class User implements UserDetails {
    ...
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {        
        return new HashSet<GrantedAuthority>();
    }
}