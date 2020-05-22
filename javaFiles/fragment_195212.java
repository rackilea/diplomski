public class AdminPermitVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        if(isAdmin(extractAuthorities(authentication))) {
            return ACCESS_GRANTED;
        }
        return ACCESS_ABSTAIN;
    }

    Collection<? extends GrantedAuthority> extractAuthorities(Authentication authentication) {
        return authentication.getAuthorities();
    }

    private boolean isAdmin(Collection<? extends GrantedAuthority> authorities) {
        for(GrantedAuthority authority : authorities) {
            if(equalsIgnoreCase(ADMIN_ROLE_NAME, authority.getAuthority())) {
                return true;
            }
        }

        return false;
    }
}