@Component
public class WithMockOAuth2ScopeSecurityContextFactory implements WithSecurityContextFactory<WithMockOAuth2Scope> {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public SecurityContext createSecurityContext(WithMockOAuth2Scope mockOAuth2Scope) {

        OAuth2AccessToken oAuth2AccessToken = createAccessToken(mockOAuth2Scope.token());
        OAuth2Authentication oAuth2Authentication = createAuthentication(mockOAuth2Scope);
        tokenStore.storeAccessToken(oAuth2AccessToken, oAuth2Authentication);

        return SecurityContextHolder.createEmptyContext();
    }


    private OAuth2AccessToken createAccessToken(String token) {
        return new DefaultOAuth2AccessToken(token);
    }

    private OAuth2Authentication createAuthentication(WithMockOAuth2Scope mockOAuth2Scope) {

        OAuth2Request oauth2Request = getOauth2Request(mockOAuth2Scope);
        return new OAuth2Authentication(oauth2Request,
                getAuthentication(mockOAuth2Scope));
    }

    private OAuth2Request getOauth2Request(WithMockOAuth2Scope mockOAuth2Scope) {
        String clientId = mockOAuth2Scope.clientId();
        boolean approved = mockOAuth2Scope.approved();
        String redirectUrl = mockOAuth2Scope.redirectUrl();
        Set<String> responseTypes = new HashSet<>(asList(mockOAuth2Scope.responseTypes()));
        Set<String> scopes = new HashSet<>(asList(mockOAuth2Scope.scopes()));
        Set<String> resourceIds = new HashSet<>(asList(mockOAuth2Scope.resourceIds()));

        Map<String, String> requestParameters = Collections.emptyMap();
        Map<String, Serializable> extensionProperties = Collections.emptyMap();
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(mockOAuth2Scope.authorities());

        return new OAuth2Request(requestParameters, clientId, authorities,
                approved, scopes, resourceIds, redirectUrl, responseTypes, extensionProperties);
    }

    private Authentication getAuthentication(WithMockOAuth2Scope mockOAuth2Scope) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList(mockOAuth2Scope.authorities());

        String username = mockOAuth2Scope.username();
        User userPrincipal = new User(username,
                mockOAuth2Scope.password(),
                true, true, true, true, grantedAuthorities);

        HashMap<String, String> details = new HashMap<>();
        details.put("user_name", username);
        details.put("email", mockOAuth2Scope.email());

        TestingAuthenticationToken token = new TestingAuthenticationToken(userPrincipal, null, grantedAuthorities);
        token.setAuthenticated(true);
        token.setDetails(details);

        return token;
    }

}