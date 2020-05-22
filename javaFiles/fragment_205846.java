/**
 * The unique identifier of the container managing for this endpoint.
 * <p>If none is specified an auto-generated one is provided.
 * @return the {@code id} for the container managing for this endpoint.
 * @see org.springframework.kafka.config.KafkaListenerEndpointRegistry#getListenerContainer(String)
 */
String id() default "";