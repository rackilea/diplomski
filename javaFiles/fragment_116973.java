InitialContext initialContext new InitialContext();
Queue requestQueue = (Queue) initialContext.lookup("requestQueue");
Queue responseQueue = (Queue) initialContext.lookup("responseQueue");
ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
String correlationID = UUID.randomUUID().toString();
JMSContext context = cf.createContext();
context.createProducer().setJMSCorrelationID(correlationID).send(requestQueue, context.createTextMessage("requestMessage"));
Message reply = context.createConsumer(responseQueue, "JMSCorrelationID = '" + correlationID + "'").receive();