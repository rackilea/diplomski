@Bean
public ProviderSignInUtils providerSignInUtils(
        final ConnectionFactoryLocator connectionFactoryLocator,
        final UsersConnectionRepository usersConnectionRepository) {
    return new ProviderSignInUtils(connectionFactoryLocator,
            usersConnectionRepository);
}