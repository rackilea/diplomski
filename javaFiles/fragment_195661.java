@KafkaListener(id = "qux", topicPattern = "myTopic1")
public void listen(@Payload String foo,
    @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
    @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
    @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts
        ) {
    ...
}