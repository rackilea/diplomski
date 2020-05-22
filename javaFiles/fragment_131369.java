@Bean
public ConnectionFactory connectionFactory(AmazonSQSClient amazonSQSclient) {

    SQSConnectionFactory sqsConnectionFactory = new SQSConnectionFactory(new ProviderConfiguration(), amazonSQSclient);

    // Doing the following is key!
    CachingConnectionFactory connectionfactory = new CachingConnectionFactory();
    connectionfactory.setTargetConnectionFactory(sqsConnectionFactory);
    // Set the #connectionfactory properties to your liking here...

    return connectionFactory;

}