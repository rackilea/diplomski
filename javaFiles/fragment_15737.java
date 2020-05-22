try {
    SimpleResourceHolder.bind(routingCF, keyForThisMessage);
    rabbitTemplate.convertAndSend(message);
}
finally {
    SimpleResourceHolder.unbind(routingCF);
}