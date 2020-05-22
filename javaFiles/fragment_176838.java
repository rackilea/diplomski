/**
 * The property name to set with the bootstrap server addresses instead of the default
 * {@value org.springframework.kafka.test.EmbeddedKafkaBroker#SPRING_EMBEDDED_KAFKA_BROKERS}.
 * @return the property name.
 * @since 2.3
 * @see org.springframework.kafka.test.EmbeddedKafkaBroker#brokerListProperty(String)
 */
String bootstrapServersProperty() default "";