@Autowired
private AMQPProperties amqpProperties;

@Autowired 
private RoutingKeyResolver routingKeyResolver;

@Autowired
private AMQPMessageConverter aMQPMessageConverter;


@Bean(initMethod = "start", destroyMethod = "shutDown")
public SpringAMQPPublisher amqpBridge(
             EventBus eventBus, 
             ConnectionFactory connectionFactory,
             AMQPMessageConverter amqpMessageConverter) {

    SpringAMQPPublisher publisher = new SelectiveAmqpPublisher(eventBus);



    // The rest is from axon-spring-autoconfigure...

    publisher.setExchangeName(amqpProperties.getExchange());
    publisher.setConnectionFactory(connectionFactory);
    publisher.setMessageConverter(amqpMessageConverter);
    switch (amqpProperties.getTransactionMode()) {

        case TRANSACTIONAL:
            publisher.setTransactional(true);
            break;
        case PUBLISHER_ACK:
            publisher.setWaitForPublisherAck(true);
            break;
        case NONE:
            break;
        default:
            throw new IllegalStateException("....");
    }

    return publisher;

}