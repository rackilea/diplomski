@JmsListener(destination = "MQ.LISTENER.INFO.HERE")
    public String receiveMessage(String text) throws JMSException {
        LOGGER.info("Received something!");
        this.jmsTemplate.receiveAndConvert("MQ.LISTENER.INFO.HERE");
        LOGGER.info("Received message from MQ.LISTENER.INFO.HERE: ");
        return "Acknowledgement from receiveMessage";
    }