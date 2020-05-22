@Bean
public SmartApplicationListener tcpErrorListener() {
    ApplicationEventListeningMessageProducer producer = new ApplicationEventListeningMessageProducer();
    producer.setEventTypes(TcpConnectionCloseEvent.class);
    producer.setOutputChannel(tcpErrorChannel());
    return producer;
}

@Bean
public MessageChannel tcpErrorChannel() {
    return new DirectChannel();
}