jmsTemplate.send("TEST_QUEUE",new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                Queue queue = session.createQueue("REPLY_QUEUE");
                message.setJMSReplyTo(queue);
                return message;
            }
        });