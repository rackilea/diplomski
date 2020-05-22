public class RealmAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private Object realm;

    public RealmAuthenticationToken(Object principal, Object credentials, Object realm, Collection<? extends GrantedAuthority> authorities) {
        super(principal,credentials, authorities);
        this.realm = realm;
    }
}