SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
container.setConnectionFactory(connectionFactory);
container.setQueueNames("queueName");
container.setMessageConverter(jsonMessageConverter());
container.setMessageListener(new Consumer(container));
container.start();