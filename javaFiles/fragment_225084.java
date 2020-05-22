@Bean
public DefaultSftpSessionFactory sftpSessionFactory() {
    final DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
    factory.setHost(applicationProperties.getSftp().getHost());
    factory.setUser(applicationProperties.getSftp().getUser());
    factory.setPassword(applicationProperties.getSftp().getPass());
    factory.setAllowUnknownKeys(true);

    return factory;
}