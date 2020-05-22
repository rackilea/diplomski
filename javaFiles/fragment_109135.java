@Configuration
public class SocialConfig implements SocialConfigurer {

    @Value("${spring.social.facebook.appId}")
    private String appId;
    @Value("${spring.social.facebook.appSecret}")
    private String appSecret;

    @Override
    public void addConnectionFactories(final ConnectionFactoryConfigurer cfConfig, final Environment env) {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory(appId, appSecret));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new SessionUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(final ConnectionFactoryLocator connectionFactoryLocator) {
        return new InMemoryUsersConnectionRepository(connectionFactoryLocator);
    }
}