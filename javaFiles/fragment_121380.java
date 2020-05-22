@Value("${jms.broker.url}") 
String brokerURL;

@Bean
public ActiveMQConnectionFactory connectionFactory() {
    final ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setBrokerURL(brokerURL);
    return activeMQConnectionFactory;
}

@Bean
@Primary
public PooledConnectionFactory pooledConnectionFactory(ConnectionFactory cf) {
    final PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
    pooledConnectionFactory.setMaxConnections(1);
    pooledConnectionFactory.setConnectionFactory(cf);
    return pooledConnectionFactory;
}

@Bean(name = "activemq")
@ConditionalOnClass(ActiveMQComponent.class)
public ActiveMQComponent activeMQComponent(ConnectionFactory connectionFactory) {
    ActiveMQComponent activeMQComponent = new ActiveMQComponent();
    activeMQComponent.setConnectionFactory(connectionFactory);
    activeMQComponent.setTransacted(true);
    activeMQComponent.setLazyCreateTransactionManager(false);
    return activeMQComponent;
}