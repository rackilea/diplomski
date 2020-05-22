@Service
public class UserService extends DefaultOAuth2UserService implements UserDetailsService {

    // ...

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(oAuth2UserRequest);

        Map<String, Object> attributes = user.getAttributes();
        Set<GrantedAuthority> authoritySet = new HashSet<>(user.getAuthorities());
        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        authoritySet.add(new SimpleGrantedAuthority("ROLE_OAUTH2"));

        return new DefaultOAuth2User(authoritySet, attributes, userNameAttributeName);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = getUserFromDatabase(username); // you'll need to provide that method (where are the username/password stored?)
        if (user == null) { // UserDetailsService doesn't allow loadUserByUsername to return null, so throw exception
            throw new UsernameNotFoundException("Couldn't find user with username '"+username+"'");
        }
        // add ROLE_BASICAUTH (you might need a custom UserDetails implementation here, because by defaut, UserDetails.getAuthorities() is immutable (I think, I might be a liar)
        return user;
    }

}