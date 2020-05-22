@SpringBootApplication
public class So59682801Application {

    public static void main(String[] args) {
        SpringApplication.run(So59682801Application.class, args).close();
    }


    @Bean
    public ApplicationRunner runner(ListenerCreator creator,
            KafkaTemplate<String, String> template, GenericApplicationContext context) {

        return args -> {
            System.out.println("Hit enter to create a listener");
            System.in.read();

            ConcurrentMessageListenerContainer<String, String> container =
                    creator.createContainer("so59682801group", "so59682801");

            // register the container as a bean so that all the "...Aware" interfaces are satisfied
            context.registerBean("so59682801", ConcurrentMessageListenerContainer.class, () -> container);
            context.getBean("so59682801", ConcurrentMessageListenerContainer.class); // re-fetch to initialize

            container.start();

            // send some messages
            IntStream.range(0, 10).forEach(i -> template.send("so59682801", "test" + i));

            System.out.println("Hit enter to reseek");
            System.in.read();
            ((MyListener) container.getContainerProperties().getMessageListener())
                .reseek(new TopicPartition("so59682801", 0), 5L);

            System.out.println("Hit enter to exit");
            System.in.read();
        };
    }

}

@Component
class ListenerCreator {

    private final ConcurrentKafkaListenerContainerFactory<String, String> factory;

    ListenerCreator(ConcurrentKafkaListenerContainerFactory<String, String> factory) {
        factory.getContainerProperties().setIdleEventInterval(5000L);
        this.factory = factory;
    }

    ConcurrentMessageListenerContainer<String, String> createContainer(String groupId, String... topics) {
        ConcurrentMessageListenerContainer<String, String> container = factory.createContainer(topics);
        container.getContainerProperties().setGroupId(groupId);
        container.getContainerProperties().setMessageListener(new MyListener());
        return container;
    }

}

class MyListener extends AbstractConsumerSeekAware implements MessageListener<String, String> {

    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        System.out.println(data);
    }

    public void reseek(TopicPartition partition, long offset) {
        getSeekCallbackFor(partition).seek(partition.topic(), partition.partition(), offset);
    }

}