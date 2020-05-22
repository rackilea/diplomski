// You want to extend your User class here
public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Users user;

    public CustomUserDetails(User user) {
        super(user);
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You don't talk about UserRoles, so return ADMIN for everybody or implement roles. 
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // just for example
        return this.user.getActive() == true;
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    // Just an example to put some addititional Data to your logged in user

    public String getUserDatabase() {
        return "usertable" + Integer.toString(1 + this.user.getUserId());
    }


}