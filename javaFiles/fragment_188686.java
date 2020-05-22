public class OAuth2TokenStoreRepositoryImpl implements TokenStore {
    @Autowired
    private OAuth2AccessTokenRepository oAuth2AccessTokenRepository;
    @Autowired
    private OAuth2RefreshTokenRepository oAuth2RefreshTokenRepository;
    private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#readAuthentication(org.springframework.security.oauth2.common.OAuth2AccessToken)
     */
    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        return readAuthentication(token.getValue());
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#readAuthentication(java.lang.String)
     */
    @Override
    public OAuth2Authentication readAuthentication(String tokenId) {
        OAuth2AuthenticationAccessToken accessToken = oAuth2AccessTokenRepository.findByTokenId(tokenId);
        OAuth2Authentication oauth2Authentication = null;
        if(accessToken != null){
            oauth2Authentication = accessToken.getAuthentication();
        }
        return oauth2Authentication;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#storeAccessToken(org.springframework.security.oauth2.common.OAuth2AccessToken, org.springframework.security.oauth2.provider.OAuth2Authentication)
     */
    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        // remove existing token & add new
        removeAccessToken(token);

        OAuth2AuthenticationAccessToken oAuth2AuthenticationAccessToken = new OAuth2AuthenticationAccessToken(token,
                authentication, authenticationKeyGenerator.extractKey(authentication));
        oAuth2AccessTokenRepository.save(oAuth2AuthenticationAccessToken);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#readAccessToken(java.lang.String)
     */
    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AuthenticationAccessToken token = oAuth2AccessTokenRepository.findByTokenId(tokenValue);
        if(token == null) {
            return null; //let spring security handle the invalid token
        }
        OAuth2AccessToken accessToken = token.getoAuth2AccessToken();
        return accessToken;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#removeAccessToken(org.springframework.security.oauth2.common.OAuth2AccessToken)
     */
    @Override
    public void removeAccessToken(OAuth2AccessToken token) {
        OAuth2AuthenticationAccessToken accessToken = oAuth2AccessTokenRepository.findByTokenId(token.getValue());
        if(accessToken != null) {
            oAuth2AccessTokenRepository.delete(accessToken);
        }

    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#storeRefreshToken(org.springframework.security.oauth2.common.OAuth2RefreshToken, org.springframework.security.oauth2.provider.OAuth2Authentication)
     */
    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        oAuth2RefreshTokenRepository.save(new OAuth2AuthenticationRefreshToken(refreshToken, authentication));

    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#readRefreshToken(java.lang.String)
     */
    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        OAuth2AuthenticationRefreshToken refreshAuth = oAuth2RefreshTokenRepository.findByTokenId(tokenValue);
        OAuth2RefreshToken refreshToken = null;
        if(refreshAuth != null){
            refreshToken = refreshAuth.getoAuth2RefreshToken();
        }
        return refreshToken;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#readAuthenticationForRefreshToken(org.springframework.security.oauth2.common.OAuth2RefreshToken)
     */
    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken( OAuth2RefreshToken token) {
        OAuth2AuthenticationRefreshToken refreshAuth = oAuth2RefreshTokenRepository.findByTokenId(token.getValue());
        OAuth2Authentication oAuth2Authentication = null;
        if(refreshAuth != null){
            oAuth2Authentication = refreshAuth.getAuthentication();
        }
        return oAuth2Authentication;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#removeRefreshToken(org.springframework.security.oauth2.common.OAuth2RefreshToken)
     */
    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {
        OAuth2AuthenticationRefreshToken refreshAuth = oAuth2RefreshTokenRepository.findByTokenId(token.getValue());
        if(refreshAuth != null){
            oAuth2RefreshTokenRepository.delete(refreshAuth);
        }
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#removeAccessTokenUsingRefreshToken(org.springframework.security.oauth2.common.OAuth2RefreshToken)
     */
    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        OAuth2AuthenticationAccessToken accessToken = oAuth2AccessTokenRepository.findByRefreshToken(refreshToken.getValue());
        if(accessToken != null){
            oAuth2AccessTokenRepository.delete(accessToken);
        }
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#getAccessToken(org.springframework.security.oauth2.provider.OAuth2Authentication)
     */
    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        OAuth2AuthenticationAccessToken token =  oAuth2AccessTokenRepository.findByAuthenticationId(authenticationKeyGenerator.extractKey(authentication));
        return token == null ? null : token.getoAuth2AccessToken();
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#findTokensByClientIdAndUserName(java.lang.String, java.lang.String)
     */
    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        List<OAuth2AuthenticationAccessToken> tokens = oAuth2AccessTokenRepository.findByClientIdAndUserName(clientId, userName);
        return extractAccessTokens(tokens);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.token.TokenStore#findTokensByClientId(java.lang.String)
     */
    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        List<OAuth2AuthenticationAccessToken> tokens = oAuth2AccessTokenRepository.findByClientId(clientId);
        return extractAccessTokens(tokens);
    }

    private Collection<OAuth2AccessToken> extractAccessTokens(List<OAuth2AuthenticationAccessToken> tokens) {
        List<OAuth2AccessToken> accessTokens = new ArrayList<OAuth2AccessToken>();
        for(OAuth2AuthenticationAccessToken token : tokens) {
            accessTokens.add(token.getoAuth2AccessToken());
        }
        return accessTokens;
    }
}