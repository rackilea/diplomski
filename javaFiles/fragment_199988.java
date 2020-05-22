@Bean
public FacebookConnectionFactory facebookConnectionFactory() {
    return new FacebookConnectionFactory(facebookAppId, facebookAppSecret);
}

@Bean
public GoogleConnectionFactory googleConnectionFactory() {
    return new GoogleConnectionFactory(googleAppId, googleAppSecret);
}

@Bean
public ConnectionFactoryLocator connectionFactoryLocator() {
    ConnectionFactoryRegistry connectionFactoryRegistry = new ConnectionFactoryRegistry();
    connectionFactoryRegistry.addConnectionFactory(facebookConnectionFactory());
    connectionFactoryRegistry.addConnectionFactory(googleConnectionFactory());
    return connectionFactoryRegistry;
}