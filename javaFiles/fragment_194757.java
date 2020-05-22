public class TokenBasedAuthentication extends AbstractAuthenticationToken {
    private final UserDetails principal;

    public TokenBasedAuthentication(AuthenticatedPrincipal principal) {
        super(principal.getAuthorities());
        this.principal = principal;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public UserDetails getPrincipal() {
        return principal;
    }
}