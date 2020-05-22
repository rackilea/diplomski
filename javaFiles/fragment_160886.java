this.jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
this.jmsTemplate.convertAndSend("foo", "bar");
try {
    String value = this.jmsTemplate.execute(session -> {
        MessageConsumer consumer = session.createConsumer(
                this.jmsTemplate.getDestinationResolver().resolveDestinationName(session, "foo", false));
        String result;
        try {
            Message received = consumer.receive(5000);
            result = (String) this.jmsTemplate.getMessageConverter().fromMessage(received);
            // Do some stuff that might throw an exception
            received.acknowledge();
        }
        finally {
            consumer.close();
        }
        return result;
    }, true);
    System.out.println(value);
}
catch (Exception e) {
    e.printStackTrace();
}