package spring4

import org.apache.activemq.jms.pool.PooledConnectionFactory
import org.apache.activemq.spring.ActiveMQConnectionFactory;

beans {
    //importBeans("classpath:spring4/IntegrationProperties.groovy")
    xmlns intjms:"http://www.springframework.org/schema/integration/jms"
    xmlns integration:"http://www.springframework.org/schema/integration"

    amqConnectionFactory (ActiveMQConnectionFactory) {
        brokerURL = "<brokerUrl>"
    }

    jmsFactory (PooledConnectionFactory) {bean ->
        bean.destroyMethod = 'stop'
        connectionFactory = amqConnectionFactory
    }

    integration.channel(id:'plainRequestChannel')
    integration.channel(id:'plainReplyChannel')
    integration.channel(id:'errorChannel')

    intjms.'inbound-gateway'(
            id:'gateway',
            'request-destination-name': "QUEUE.IN",
            'default-reply-queueName': "QUEUE.OUT",
            'request-channel': 'plainRequestChannel',
            'error-channel': 'errorChannel',
            'reply-channel': 'plainReplyChannel',
            'connection-factory': 'jmsFactory'
    )
}