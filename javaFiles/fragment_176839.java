@ClassRule
public static EmbeddedKafkaRule broker = new EmbeddedKafkaRule(1, false, "someTopic");

@BeforeAll
pubic static void setup() {
    broker.getEmbeddedKafka().brokerListProperty("spring.kafka.bootstrap-servers");
}