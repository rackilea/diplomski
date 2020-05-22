<int-amqp:inbound-gateway 
    connection-factory="connectionFactory" 
    request-channel="requestChannel"
    reply-channel="replyChannel" 
    error-channel="errorChannel"
    queue-names="${rabbitmq.queue}"/>