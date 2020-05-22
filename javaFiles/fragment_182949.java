* Messaging Annotation to mark a {@link org.springframework.context.annotation.Bean}
* method for a {@link org.springframework.messaging.MessageChannel} to produce a
* {@link org.springframework.integration.handler.BridgeHandler} and Consumer Endpoint.
* <p>
* The {@link org.springframework.messaging.MessageChannel} {@link org.springframework.context.annotation.Bean}
* marked with this annotation is used as the {@code inputChannel} for the
* {@link org.springframework.integration.endpoint.AbstractEndpoint}
* and determines the type of endpoint -
* {@link org.springframework.integration.endpoint.EventDrivenConsumer} or
* {@link org.springframework.integration.endpoint.PollingConsumer}.