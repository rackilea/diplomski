@SpringBootApplication
public class So46918267Application {

    public static void main(String[] args) throws IOException {
        // Simulated Server
        final ServerSocket server = ServerSocketFactory.getDefault().createServerSocket(1234);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                Socket socket = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    if (line.equals("keep_alive")) {
                        socket.getOutputStream().write("OK\r\n".getBytes());
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        ConfigurableApplicationContext context = SpringApplication.run(So46918267Application.class, args);
        System.out.println("Hit enter to terminate");
        System.in.read();
        executor.shutdownNow();
        context.close();
        server.close();
    }

    @Bean
    public TcpNetClientConnectionFactory client() {
        return new TcpNetClientConnectionFactory("localhost", 1234);
    }

    @ServiceActivator(inputChannel = "toTcp")
    @Bean
    public TcpOutboundGateway gateway() {
        TcpOutboundGateway gateway = new TcpOutboundGateway();
        gateway.setConnectionFactory(client());
        return gateway;
    }

    // HEARTBEATS

    private final Message<?> heartbeatMessage = MessageBuilder.withPayload("keep_alive")
            .setReplyChannelName("heartbeatReplies")
            .build();

    @InboundChannelAdapter(channel = "toTcp", poller = @Poller(fixedDelay = "25000"))
    public Message<?> heartbeat() {
        return this.heartbeatMessage;
    }

    @ServiceActivator(inputChannel = "heartbeatReplies")
    public void reply(byte[] reply) {
        System.out.println(new String(reply));
    }

}