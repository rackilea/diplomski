@Override
public Message readMessageFromRetryQueueByJmsId(String jmsId) throws QueueingException {
    Connection connection = null;
    Session session = null;
    MessageConsumer messageConsumer = null;
    Message message = null;
    try {
        connection = getConnectionFactory().createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
        messageConsumer = session.createConsumer(getRetryQueue(), "JMSMessageID='"+jmsId+"'");
        message = messageConsumer.receiveNoWait();
    } catch (JMSException e) {
        throw new QueueingException("Failed to read message from MessageConsumer.");
    } finally {
        try { connection.close(); } catch (Exception e) {}
    }
    return message;
}