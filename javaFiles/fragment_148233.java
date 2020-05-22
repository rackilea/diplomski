@SpringBootApplication
public class So44760185Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(So44760185Application.class, args);
        MessageChannel channel = context.getBean("clientChannel", MessageChannel.class);
        try {
            channel.send(new GenericMessage<>("foo"));
            System.err.println("Expected ConnectException");
        }
        catch (MessagingException e) {
            if (!(e.getCause().getCause() instanceof ConnectException)) {
                throw e;
            }
            System.out.println("good1");
        }

        context.getBean(ShuttingDownAdvice.class).shuttingDown = true;

        try {
            channel.send(new GenericMessage<>("foo"));
            System.err.println("Expected shutting down exception");
        }
        catch (MessagingException e) {
            if (!(e.getCause().getMessage().equals("No new connections allowed"))) {
                throw e;
            }
            System.out.println("good2");
        }
        context.close();
    }

    @Bean
    public static TcpConnectionFactoryFactoryBean connectionFactoryBean() {
        TcpConnectionFactoryFactoryBean f = new TcpConnectionFactoryFactoryBean();
        f.setType("client");
        f.setHost("localhost");
        f.setPort(1234);
        return f;
    }

    @Bean
    @ServiceActivator(inputChannel = "clientChannel")
    public TcpOutboundGateway outboundGateway(AbstractClientConnectionFactory factory) throws Exception {
        TcpOutboundGateway g = new TcpOutboundGateway();
        g.setConnectionFactory(factory);
        g.setRequiresReply(true);
        g.setAdviceChain(Collections.singletonList(advice()));
        return g;
    }

    @Bean
    public ShuttingDownAdvice advice() {
        return new ShuttingDownAdvice();
    }

    public static class ShuttingDownAdvice extends AbstractRequestHandlerAdvice {

        private volatile boolean shuttingDown;

        @Override
        protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) throws Exception {
            if (this.shuttingDown) {
                throw new RuntimeException("No new connections allowed");
            }
            return callback.execute();
        }

    }

}