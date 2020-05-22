@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@DirtiesContext
@TestPropertySource({"classpath:application-test.properties"})
public class PublishCustomerServiceImplTest {

private static final String TOPIC = "TopicName";

 @ClassRule
public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, true, TOPIC);

public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, embeddedKafka.getEmbeddedKafka().getBrokersAsString());
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.RETRIES_CONFIG, 3);
    props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
    return props;
}

public ProducerFactory<String, CustomerPublishRequest> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
}

public KafkaTemplate<String, CustomerPublishRequest> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
}

@Test
public void publishCustomerTest() throws Exception {

    KafkaTemplate<String, CustomerPublishRequest> kafkaTemplate = kafkaTemplate();

    ListenableFuture<SendResult<String, CustomerPublishRequest>> future = kafkaTemplate.send(TOPIC, CustomerRequestDummy.getCustomer());
    SendResult<String, CustomerPublishRequest> sendResult = future.get();
    long offset = sendResult.getRecordMetadata().offset();

    }
}