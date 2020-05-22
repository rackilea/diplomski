InitialContext initialContext new InitialContext();
Queue queue = (Queue) initialContext.lookup("myQueue");
QueueConnectionFactory cf = (QueueConnectionFactory) initialContext.lookup("ConnectionFactory");
QueueConnection connection = cf.createQueueConnection();
connection.start();
QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
MessageConsumer messageConsumer = session.createConsumer(queue);
TextMessage request = (TextMessage) messageConsumer.receive();
TextMessage reply = session.createTextMessage("reply: " + request.getText());
Destination replyTo = request.getJMSReplyTo();
try (MessageProducer producer = session.createProducer(replyTo)) {
    producer.send(reply);
}