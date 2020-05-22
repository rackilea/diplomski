public void test() throws Exception {

    final Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                final Connection connection = connectionFactory.createConnection();

                connection.start();

                final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                final MessageConsumer incoming = session.createConsumer(requestQueue);
                final String text = ((TextMessage) incoming.receive(1000)).getText();

                final MessageProducer outgoing = session.createProducer(responseQueue);
                outgoing.send(session.createTextMessage("Hello World!"));

            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    };
    thread.setDaemon(true);
    thread.start();

    myBean.doThatThing();

    // asserts here...
}