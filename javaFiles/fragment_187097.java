@SpringBootApplication
public class So40408085Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So40408085Application.class, args);
        context.getBean("toTcp", MessageChannel.class).send(new GenericMessage<>("foo"));
        Thread.sleep(5000);
        context.close();
    }

    @Bean
    public TcpNetServerConnectionFactory server() {
        TcpNetServerConnectionFactory server = new TcpNetServerConnectionFactory(1234);
        server.setSoTimeout(1000);
        server.setMapper(new TimeoutMapper()); // use 'mapper' attribute in XML
        return server;
    }

    @Bean
    public TcpInboundGateway inGate() {
        TcpInboundGateway inGate = new TcpInboundGateway();
        inGate.setConnectionFactory(server());
        inGate.setRequestChannelName("inChannel");
        return inGate;
    }

    @ServiceActivator(inputChannel = "inChannel")
    public String upCase(byte[] in) {
        return new String(in).toUpperCase();
    }

    @Bean
    public TcpNetClientConnectionFactory client() {
        TcpNetClientConnectionFactory client = new TcpNetClientConnectionFactory("localhost", 1234);
        client.setSerializer(new ByteArrayLfSerializer()); // so the server will timeout - he's expecting CRLF
        return client;
    }

    @Bean
    @ServiceActivator(inputChannel = "toTcp")
    public TcpOutboundGateway out() {
        TcpOutboundGateway outGate = new TcpOutboundGateway();
        outGate.setConnectionFactory(client());
        outGate.setOutputChannelName("reply");
        return outGate;
    }

    @ServiceActivator(inputChannel = "reply")
    public void reply(byte[] in) {
        System.out.println(new String(in));
    }

    public static class TimeoutMapper extends TcpMessageMapper {

        @Override
        public Message<?> toMessage(TcpConnection connection) throws Exception {
            try {
                return super.toMessage(connection);
            }
            catch (SocketTimeoutException e) {
                connection.send(new GenericMessage<>("You took too long to send me data, sorry"));
                connection.close();
                return null;
            }
        }

    }

}