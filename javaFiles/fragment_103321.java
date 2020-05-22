try {

  // 1) Create a MQ connection factory
  JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
  JmsConnectionFactory cf = ff.createConnectionFactory();

  // 2) Set the properties
  cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, HOST);
  cf.setIntProperty(WMQConstants.WMQ_PORT, PORT);
  cf.setStringProperty(WMQConstants.WMQ_CHANNEL, CHANNEL);
  cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
  cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, QMGR);
  cf.setStringProperty(WMQConstants.WMQ_APPLICATIONNAME, "JmsPutGet (JMS)");
  cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, true);
  cf.setStringProperty(WMQConstants.USERID, APP_USER);
  cf.setStringProperty(WMQConstants.PASSWORD, APP_PASSWORD);

  // 3) Create MQ consumer
  JMSContext mqContext = cf.createContext();
  destination = mqContext.createQueue("queue:///" + QUEUE_NAME);
  consumer = mqContext.createConsumer(destination); // autoclosable

  // 4)  wait for message from MQ (or null)
  String receivedText = mqContext.receiveBody(String.class, 15000); // in ms or 15 seconds
  System.out.println("\nReceived message:\n" + receivedText);

  // 5) Create TIBCO EMS ConnectionFactory and an EMS MessageProducer
  TibjmsConnectionFactory emsCF = new com.tibco.tibjms.TibjmsConnectionFactory( "tcp://1.2.3.4:7222");
  Connection emsConnection = emsCF.createConnection(user, password);
  Session emsSession = emsConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
  MessageProducer emsProducer = emsSession.createProducer( emsSession.createQueue(QUEUE_NAME) );

  // 6) Create EMS TextMessage from MQ TextMessage
  TextMessage emsMsg = emsSession.createTextMessage( receivedText );

  // 7) publish to EMS
  emsProducer.send(emsMsg);

  // 8) cleanup
  emsConnection.close();

  recordSuccess();
} catch (JMSException jmsex) {
   recordFailure(jmsex);
}