/**
 * Send a message to a default exchange with a specific routing key.
 *
 * @param routingKey the routing key
 * @param message a message to send
 * @throws AmqpException if there is a problem
 */
void send(String routingKey, Message message) throws AmqpException;