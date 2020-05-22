@KafkaListener(....)
public void consume(ConsumerRecord<?, ?> consumerRecord,  
        Acknowledgment acknowledgment) {

    // Consume record

    acknowledgment.acknowledge();
}