HttpConfiguration https = new HttpConfiguration();
https.addCustomizer(new SecureRequestCustomizer());
SslContextFactory sslContextFactory = new JettySslContextFactory(configuration.getSslProviders());
ServerConnector sslConnector = new ServerConnector(
    server,
    new SslConnectionFactory(sslContextFactory, "http/1.1"),
    new HttpConnectionFactory(https)
);
sslConnector.setPort(httpsPort);