@Configuration
public class ConsumerCreator {

    @Autowired
    StreamingConsumerFactory factory;

    @Bean
    public StreamingConsumer streamingConsumer() {
        return factory.createStreamingConsumer(StreamType.valueOf(env.getRequiredProperty("streaming.application.type")));
    }
}