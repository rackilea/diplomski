@PostConstruct
public void startServer() {
    RSocketFactory.receive()
            .acceptor((setup, sendingSocket) -> Mono.just(new MqttMessageService()))
            .transport(TcpServerTransport.create(8802))
            .start()
            .block()
            .onClose();
}