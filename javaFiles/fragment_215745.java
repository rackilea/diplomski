@Configuration
@EnableJms
public class JmsConfig {

private static final Logger LOGGER = LoggerFactory.getLogger(JmsConfig.class);
private static final String LOWER_UPPER_CONCURRENCY = "3-10";

public JmsConfig() {
    LOGGER.info("Loading JmsConfig");
}

@Bean
public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(SQSConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setDestinationResolver(new DynamicDestinationResolver());
    factory.setConcurrency(LOWER_UPPER_CONCURRENCY);
    factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
    return factory;
}

@Bean
public SQSConnectionFactory sqsConnectionFactory(RegionProvider regionProvider, AWSCredentialsProvider awsCredentialsProvider) {
    return SQSConnectionFactory.builder()
            .withRegion(regionProvider.getRegion())
            .withAWSCredentialsProvider(awsCredentialsProvider)
            .build();
}

@Bean
public JmsTemplate defaultJmsTemplate(SQSConnectionFactory connectionFactory) {
    return new JmsTemplate(connectionFactory);
}

}