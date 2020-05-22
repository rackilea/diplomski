@NodeEntity
public class OAuth2AuthenticationRefreshToken extends AbstractDomainEntity {
    private static final long serialVersionUID = -3269934495553717378L;

    @Indexed
    private String tokenId;

    @GraphProperty(propertyType = String.class)
    private OAuth2RefreshToken oAuth2RefreshToken;

    @GraphProperty(propertyType = String.class)
    private OAuth2Authentication authentication;

    public OAuth2AuthenticationRefreshToken(){
        super();
    }

    public OAuth2AuthenticationRefreshToken(final OAuth2RefreshToken oAuth2RefreshToken, final OAuth2Authentication authentication) {
        super(UUID.randomUUID().toString());
        this.oAuth2RefreshToken = oAuth2RefreshToken;
        this.authentication = authentication;
        this.tokenId = oAuth2RefreshToken.getValue();
    }
//gets sets