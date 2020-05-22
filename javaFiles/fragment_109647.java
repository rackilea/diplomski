public TcpInboundGateway testGate() {
    final AbstractClientConnectionFactory connectionFactory = new TcpNetClientConnectionFactory("localhost", 5959); // already running socket
    connectionFactory.setApplicationEventPublisher(new NullEventPublisher());
    final TcpOutboundGateway gate = new TcpOutboundGateway();
    gate.setConnectionFactory(connectionFactory);
    gate.setOutputChannelName("testChannel");
    return gate;
}