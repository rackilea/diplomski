public static void main(String[] args) throws Exception {
    BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:4848)"));
    broker.setSchedulerSupport(true);
    broker.start();
    Connection connection = null;
    try {
        // Producer
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:4848");
        connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("customerQueue");
        String payload = "Important Task";
        Message msg = session.createTextMessage(payload);
        MessageProducer producer = session.createProducer(queue);
        System.out.println("Sending text '" + payload + "'");
        msg.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 5000L);
        producer.send(msg);
        connection.start();

        // Consumer
        MessageConsumer consumer = null;
        consumer = session.createConsumer(queue);

        QueueBrowser browser = session.createBrowser(queue);
        while (browser.getEnumeration().hasMoreElements()) {
            TextMessage textMsg = (TextMessage) consumer.receive();
            browser.getEnumeration().nextElement();
            System.out.println(textMsg);
            System.out.println("Received: " + textMsg.getText());
        }

        session.close();
    } finally{
        if (connection != null) {
            connection.close();
        }
        broker.stop();
    }
}