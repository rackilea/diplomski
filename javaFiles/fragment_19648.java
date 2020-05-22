public static void main(String[] args) {


    // Variables

Connection connection = null;
Session session = null;
Queue destination = null;
QueueBrowser browser = null;

try {
  // Create a connection factory
  JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
  JmsConnectionFactory cf = ff.createConnectionFactory();

  // Set the properties
  cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, host);
  cf.setIntProperty(WMQConstants.WMQ_PORT, port);
  cf.setStringProperty(WMQConstants.WMQ_CHANNEL, channel);
  if (clientTransport) {
      cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
  }
  else {
      cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_BINDINGS);
  }
  cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, queueManagerName);

  // Create JMS objects
  connection = cf.createConnection();
  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
  destination = session.createQueue(queueName);
  browser = session.createBrowser(destination);

  // Start the connection
  connection.start();

  // And, browse the message
  Enumeration<?> messages = browser.getEnumeration();
  int count = 0;
  Message current;
  System.out.println("Browse starts");
  while (messages.hasMoreElements()) {
    current = (Message) messages.nextElement();
    System.out.println("\nMessage " + ++count + ":\n");
    System.out.println(current);
  }
  System.out.println("\nNo more messages\n");

  recordSuccess();
}
catch (JMSException jmsex) {
  recordFailure(jmsex);
}
finally {
  if (browser != null) {
    try {
      browser.close();
    }
    catch (JMSException jmsex) {
      System.out.println("Browser could not be closed.");
      recordFailure(jmsex);
    }
  }

  if (session != null) {
    try {
      session.close();
    }
    catch (JMSException jmsex) {
      System.out.println("Session could not be closed.");
      recordFailure(jmsex);
    }
  }

  if (connection != null) {
    try {
      connection.close();
    }
    catch (JMSException jmsex) {
      System.out.println("Connection could not be closed.");
      recordFailure(jmsex);
    }
  }
}
System.exit(status);
return;