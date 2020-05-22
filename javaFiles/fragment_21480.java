MQConnectionFactory factory = new MQConnectionFactory();
factory.setQueueManager("QM_host")
MQQueue destination = new MQQueue("default");
destination.setTargetClient(JMSC.MQJMS_CLIENT_NONJMS_MQ);
Connection connection = factory.createConnection();
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
MessageProducer producer = session.createProducer(destination);

String groupId = "ID:" + new BigInteger(24 * 8, new Random()).toString(16);

for (int i = 1; i <= 5; i++) {

    TextMessage message = session.createTextMessage();
    message.setStringProperty("JMSXGroupID", groupId);
    message.setIntProperty("JMSXGroupSeq", i);

    if (i == 5) {
        message.setBooleanProperty("JMS_IBM_Last_Msg_In_Group", true);
    }

    message.setText("Message " + i);
    producer.send(message);

}

connection.close();