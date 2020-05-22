@SpringBootApplication
@EnableJpaAuditing
public class TopicCreator {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    AdminClient kafkaAdminClient = KafkaAdminClient.create(properties);
    CreateTopicsResult result = kafkaAdminClient.createTopics(
            Stream.of("foo", "bar", "baz").map(
                    name -> new NewTopic(name, 3, (short) 1)
            ).collect(Collectors.toList())
    );
    result.all().get();
  }

}