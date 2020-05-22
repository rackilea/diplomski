InitialContext initialContext new InitialContext();
Queue requestQueue = (Queue) initialContext.lookup("requestQueue");
Queue responseQueue = (Queue) initialContext.lookup("responseQueue");
ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
JMSContext context = cf.createContext();
Message request = context.createConsumer(requestQueue).receive();
context.createProducer().setJMSCorrelationID(request.getJMSCorrelationID()).send(responseQueue, context.createTextMessage("responseMessage"));