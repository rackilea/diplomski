@SpringBootApplication
public class So47995535Application {

    public static void main(String[] args) {
        SpringApplication.run(So47995535Application.class, args).close();
    }

    private final CountDownLatch latch = new CountDownLatch(100);

    private int nativeCount;

    private int rlCount;

    @Bean
    public ApplicationRunner runner(ConnectionFactory factory, RabbitTemplate template,
            SimpleMessageListenerContainer container) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                template.convertAndSend("foo", "foo" + i);
            }
            container.start();
            Connection conn = factory.createConnection();
            Channel channel = conn.createChannel(false);
            channel.basicQos(1);
            channel.basicConsume("foo", new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
                        byte[] body) throws IOException {
                    System.out.println("native " + new String(body));
                    channel.basicAck(envelope.getDeliveryTag(), false);
                    nativeCount++;
                    latch.countDown();
                }

            });
            latch.await(60, TimeUnit.SECONDS);
            System.out.println("Native: " + this.nativeCount + " LC: " + this.rlCount);
            channel.close();
            conn.close();
            container.stop();
        };
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames("foo");
        container.setPrefetchCount(1);
        container.setAutoStartup(false);
        container.setMessageListener((MessageListener) m -> {
            System.out.println("LC " + new String(m.getBody()));
            this.rlCount++;
            this.latch.countDown();
        });
        return container;
    }

}