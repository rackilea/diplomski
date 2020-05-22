public class MyPreAuthenticatedUserDetailsService implements 
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

  @Override
  public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token)
      throws UsernameNotFoundException {
    MySessionUserDetails sessionUserDetails =
        (MySessionUserDetails) token.getDetails();
    List<GrantedAuthority> authorities = sessionUserDetails.getAuthorities();
    return new User(token.getName(), "N/A", true, true, true, true, authorities);
  }
}