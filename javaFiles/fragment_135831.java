@RunWith(SpringRunner.class)
public class So53136882ApplicationTests {

    @Autowired
    private RabbitListenerEndpointRegistry registry;

    @Autowired
    private SomeService service;

    @Test
    public void test() throws Exception {
        SimpleMessageListenerContainer container = (SimpleMessageListenerContainer) this.registry
                .getListenerContainer("myListener");
        ChannelAwareMessageListener listener = (ChannelAwareMessageListener) container.getMessageListener();
        Message message = MessageBuilder.withBody("{\"bar\":\"baz\"}".getBytes())
                .andProperties(MessagePropertiesBuilder.newInstance()
                        .setContentType("application/json")
                        .build())
                .build();
        listener.onMessage(message, mock(Channel.class));
        verify(this.service).process(new Foo("baz"));
    }

    @Configuration
    @EnableRabbit
    public static class config {

        @Bean
        public ConnectionFactory mockCf() {
            return mock(ConnectionFactory.class);
        }

        @Bean
        public MessageConverter converter() {
            return new Jackson2JsonMessageConverter();
        }

        @Bean
        public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
            factory.setConnectionFactory(mockCf());
            factory.setMessageConverter(converter());
            factory.setAutoStartup(false);
            return factory;
        }

        @Bean
        public MyListener myListener() {
            return new MyListener();
        }

        @Bean
        public SomeService service() {
            return mock(SomeService.class);
        }

    }

}