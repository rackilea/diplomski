import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import static org.springframework.amqp.core.ExchangeTypes.TOPIC;

@Component
public class ReuathenticationListener {

    private static Logger log = LoggerFactory.getLogger(ReuathenticationListener.class);

    @Autowired private RabbitProperties rabbitProperties;
    @Autowired private RefreshEndpoint refreshEndpoint;
    @Autowired private CachingConnectionFactory connectionFactory;

    @RabbitListener(
        id = "credential_expiry_listener",
        bindings = @QueueBinding(value = @Queue(value="credentials.expiry", autoDelete="true", durable="false"),
            exchange = @Exchange(value="amq.rabbitmq.event", type=TOPIC, internal="true", durable="true"),
            key = "user.#")
    )
    public void expiryHandler(final MessageHeaders headers) {
        final String key = (String) headers.get("amqp_receivedRoutingKey");
        // See: https://www.rabbitmq.com/event-exchange.html
        if (!key.equals("user.deleted") &&
            !key.equals("user.authentication.failure")) {
            return;
        }

        final String failedName = (String) headers.get("name");
        final String prevUsername = rabbitProperties.getUsername();

        if (!failedName.equals(prevUsername)) {
            log.debug("Ignore expiry of unrelated user: " + failedName);
            return;
        }

        log.info("Refreshing Rabbit credentials...");
        refreshEndpoint.refresh();
        log.info("Refreshed username: '" + prevUsername + "' => '" + rabbitProperties.getUsername() + "'");

        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        connectionFactory.resetConnection();

        log.info("CachingConnectionFactory reset, reconnection should now begin.");
    }
}