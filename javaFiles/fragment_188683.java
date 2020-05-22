@NodeEntity
public class OAuth2AuthenticationAccessToken extends AbstractDomainEntity {
    private static final long serialVersionUID = -3919074495651349876L;

@Indexed
private String tokenId;
@GraphProperty(propertyType = String.class)
private OAuth2AccessToken oAuth2AccessToken;
@Indexed
private String authenticationId;
@Indexed
private String userName;
@Indexed
private String clientId;
@GraphProperty(propertyType = String.class)
private OAuth2Authentication authentication;
@Indexed
private String refreshToken;

public OAuth2AuthenticationAccessToken(){
    super();
}

public OAuth2AuthenticationAccessToken(final OAuth2AccessToken oAuth2AccessToken, final OAuth2Authentication authentication, final String authenticationId) {
    super(UUID.randomUUID().toString());
    this.tokenId = oAuth2AccessToken.getValue();
    this.oAuth2AccessToken = oAuth2AccessToken;
    this.authenticationId = authenticationId;
    this.userName = authentication.getName();
    this.clientId = authentication.getOAuth2Request().getClientId();
    this.authentication = authentication;
    this.refreshToken = oAuth2AccessToken.getRefreshToken() != null ? 

oAuth2AccessToken.getRefreshToken().getValue() : null;
    }
//getters setters