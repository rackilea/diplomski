public interface OAuth2AccessTokenRepository extends GraphRepository<OAuth2AuthenticationAccessToken>, CypherDslRepository<OAuth2AuthenticationAccessToken>, OAuth2AccessTokenRepositoryCustom {
    public OAuth2AuthenticationAccessToken findByTokenId(String tokenId);
    public OAuth2AuthenticationAccessToken findByRefreshToken(String refreshToken);
    public OAuth2AuthenticationAccessToken findByAuthenticationId(String authenticationId);
    public List<OAuth2AuthenticationAccessToken> findByClientIdAndUserName(String clientId, String userName);
    public List<OAuth2AuthenticationAccessToken> findByClientId(String clientId);
}