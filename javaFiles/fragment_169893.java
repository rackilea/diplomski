/**
 * Set the concurrency of the listener container for this listener. Overrides the
 * default set by the listener container factory. Maps to the concurrency setting of
 * the container type.
 * <p>For a
 * {@link org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
 * SimpleMessageListenerContainer} if this value is a simple integer, it sets a fixed
 * number of consumers in the {@code concurrentConsumers} property. If it is a string
 * with the form {@code "m-n"}, the {@code concurrentConsumers} is set to {@code m}
 * and the {@code maxConcurrentConsumers} is set to {@code n}.
 * <p>For a
 * {@link org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer
 * DirectMessageListenerContainer} it sets the {@code consumersPerQueue} property.
 * @return the concurrency.
 * @since 2.0
 */
String concurrency() default "";