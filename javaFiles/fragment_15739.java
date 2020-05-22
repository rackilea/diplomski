this.routingTemplate.convertAndSend("exchange", "routingKey", "xyz", new MessagePostProcessor() {

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties().setHeader("cfKey", "foo");
        return message;
    }

});