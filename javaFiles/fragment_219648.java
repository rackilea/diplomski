@Configuration
class KafkaConfiguration {

        @Bean
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {

            final Map<String, Object> consumerProperties = kafkaProperties.buildConsumerProperties();
            consumerProperties.put(ENABLE_AUTO_COMMIT_CONFIG, false);

            ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.getContainerProperties().setAckMode(MANUAL);

            return factory;
        }
    }
}