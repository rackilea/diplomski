@Bean
public ApplicationRunner runner(KafkaReceiver<String, String> kafkaReceiver) {
        return args -> {
                kafkaReceiver.receive()
                          ...
                          .sunbscribe();
        };
}