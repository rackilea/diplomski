@Transactional(propagation = Propagation.REQUIRES_NEW)
public void publishFailSafe(String routingKey, String event) {
    try {
        rabbitTemplate.convertAndSend(routingKey.getRoutingKey(), event);
    } catch (Exception exception) {
        //Do some recovering
    }
}