@SpringBootApplication
public class So41760289Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So41760289Application.class, args);
        Socket socket = SocketFactory.getDefault().createSocket("localhost", 12345);

        // request/reply
        socket.getOutputStream().write("foo\r\n".getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());

        // arbitrary send
        @SuppressWarnings("unchecked")
        Set<String> connections = context.getBean(Set.class);
        for (String connection : connections) {
            context.getBean("bar", MessageChannel.class).send(
                    MessageBuilder.withPayload("foo")
                        .setHeader(IpHeaders.CONNECTION_ID, connection)
                        .build());
        }
        System.out.println(reader.readLine());
        reader.close();
        context.close();
    }

    @Bean
    public TcpNetServerConnectionFactory cf() {
        return new TcpNetServerConnectionFactory(12345);
    }

    @Bean
    public TcpReceivingChannelAdapter receiver() {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(cf());
        adapter.setOutputChannelName("foo");
        return adapter;
    }

    @Transformer(inputChannel = "foo", outputChannel = "bar")
    public String process(byte[] in) {
        return new String(in).toUpperCase();
    }

    @Bean
    @ServiceActivator(inputChannel = "bar")
    public TcpSendingMessageHandler sender() {
        TcpSendingMessageHandler handler = new TcpSendingMessageHandler();
        handler.setConnectionFactory(cf());
        return handler;
    }

    @Bean
    public Set<String> connections() {
        return Collections.synchronizedSet(new HashSet<>());
    }

    @Bean
    public ApplicationListener<TcpConnectionEvent> listener() {
        return new ApplicationListener<TcpConnectionEvent>() {

            @Override
            public void onApplicationEvent(TcpConnectionEvent event) {
                if (event instanceof TcpConnectionOpenEvent) {
                    connections().add(event.getConnectionId());
                }
                else if (event instanceof TcpConnectionCloseEvent) {
                    connections().remove(event.getConnectionId());
                }
            }

        };
    }

}