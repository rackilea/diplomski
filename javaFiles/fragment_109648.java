@SpringBootApplication
public class So49046888Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(So49046888Application.class, args);
        String reply = ctx.getBean(TestGateway.class).sendMessage("foo").get();
        System.out.println(reply);
        Thread.sleep(10_000);
        ctx.close();
    }

    @Bean
    public ServerSocket serverSocket() throws IOException {
        return ServerSocketFactory.getDefault().createServerSocket(5959);
    }

    @Bean
    public ApplicationRunner runner(TaskExecutor exec) {
        return args -> {
            exec.execute(() -> {
                try {
                    while (true) {
                        Socket socket = serverSocket().accept();
                        final OutputStream os = socket.getOutputStream();
                        final PrintWriter pw = new PrintWriter(os, true);
                        final BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        final String incoming = br.readLine();
                        System.out.println(incoming);
                        final String response= "ok\r\n";
                        pw.print(response);
                        pw.flush();
                        Thread.sleep(5000);
                        pw.close();
                        socket.close();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        };
    }

    @Bean
    public TaskExecutor exec() {
        return new ThreadPoolTaskExecutor();
    }

    @Bean
    @ServiceActivator(inputChannel = "testGateway")
    public MessageHandler testGate() {
        final TcpOutboundGateway gate = new TcpOutboundGateway();
        gate.setConnectionFactory(connectionFactory());
        gate.setReplyChannelName("toString");
        gate.setRemoteTimeout(60_000);
        return gate;
    }

    @Transformer(inputChannel = "toString")
    public String transform(byte[] bytes) {
        return new String(bytes);
    }

    @Bean
    public AbstractClientConnectionFactory connectionFactory() {
        final AbstractClientConnectionFactory connectionFactory = new TcpNetClientConnectionFactory("localhost", 5959);
        connectionFactory.setSoTimeout(300000);
        return connectionFactory;
    }

    @MessagingGateway(defaultRequestChannel = "testGateway")
    public static interface TestGateway {
        public Future<String> sendMessage(String in);
    }

}