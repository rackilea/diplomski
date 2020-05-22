public static void main(String[] args) throws JMSException, InterruptedException, NamingException {
    Connection connection = null;
    try {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.qpid.jms.jndi.JmsInitialContextFactory");
        props.setProperty("connectionfactory.myFactoryLookup",
                "amqp://localhost:5672");
        props.put("topic." + "MyTOPIC", "customerTopic");
        InitialContext ic = new InitialContext(props);
        ConnectionFactory cf1 = (ConnectionFactory) ic.lookup("myFactoryLookup");
        Topic topic = (Topic) ic.lookup("MyTOPIC");
        connection = cf1.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(topic);
        connection.start();
        for (int i = 0; i < 10; i++) {
            Message msg = session.createTextMessage("Task : " + i);
            producer.send(msg);
        }
        session.close();
    } finally {
        if (connection != null) {
            connection.close();
        }
    }
}