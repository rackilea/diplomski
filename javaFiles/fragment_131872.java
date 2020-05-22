MQQueueConnectionFactory qconFactory = new MQQueueConnectionFactory();
qconFactory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP); //Used when the MQSeries server is on a different host from the client
qconFactory.setQueueManager(queueManager);
qconFactory.setHostName(hostName);
qconFactory.setPort(port);
qconFactory.setChannel(channel);
connection = qconFactory.createQueueConnection();
session1 = connection.createQueueSession(true, Session.CLIENT_ACKNOWLEDGE);.....