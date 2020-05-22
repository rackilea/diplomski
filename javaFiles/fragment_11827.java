@SpringBootApplication
public class So47846492Application {

    public static void main(String[] args) {
        SpringApplication.run(So47846492Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner(MyGate gate) {
        return args -> {
            gate.send("someTopic", "foo");
            Thread.sleep(5_000);
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "toMqtt")
    public MqttPahoMessageHandler mqtt() {
        MqttPahoMessageHandler handler = new MqttPahoMessageHandler("tcp://localhost:1883", "foo",
                clientFactory());
        handler.setDefaultTopic("myTopic");
        handler.setQosExpressionString("1");
        return handler;
    }

    @Bean
    public MqttPahoClientFactory clientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setUserName("guest");
        factory.setPassword("guest");
        return factory;
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter mqttIn() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter("tcp://localhost:1883", "bar", "someTopic");
        adapter.setOutputChannelName("fromMqtt");
        return adapter;
    }

    @ServiceActivator(inputChannel = "fromMqtt")
    public void in(String in) {
        System.out.println(in);
    }

    @MessagingGateway(defaultRequestChannel = "toMqtt")
    public interface MyGate {

        void send(@Header(MqttHeaders.TOPIC) String topic, String out);

    }

}