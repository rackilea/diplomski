Destination advisoryDestination = org.apache.activemq.advisory.AdvisorySupport
                    .getMessageConsumedAdvisoryTopic(session.createQueue("yourQueue"));
            MessageConsumer consumer = session.createConsumer(advisoryDestination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message msg) {
                    System.out.println(msg);
                    System.out.println(((ActiveMQMessage) msg).getMessageId());
                    ActiveMQMessage aMsg = (ActiveMQMessage) ((ActiveMQMessage) msg).getDataStructure();
                    System.out.println(aMsg.getMessageId());
                }
            });