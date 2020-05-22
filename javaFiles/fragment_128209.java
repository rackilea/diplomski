@Bean
public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setAddresses(address);
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    return connectionFactory;
}