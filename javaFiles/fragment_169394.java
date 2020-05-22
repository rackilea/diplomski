void customConsumer(java.util.function.Consumer<ConsumerRecord<String, String>> consumer) {
    KafkaConsumer.subscribe(Collections.singleton(topic));
    try {
        while (true) {
            ConsumerRecords<String, String> consumerRecords = KafkaConsumer.poll(10);
            for(ConsumerRecord<String, String> consumerRecord : consumerRecords){
                consumer.accept(consumerRecord);
            }
        }
    } catch (Exception e){
        throw new KafkaException(e.getMessage());
    }
}