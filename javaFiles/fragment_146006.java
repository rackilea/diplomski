Context                  jndiContext = null;
ConnectionFactory   connectionFactory = null;
Connection             connection = null;
Session                  session = null;
Queue                    queue = null;
MessageProducer     messageProducer = null;   

try
{
    //[1] Create a JNDI API InitialContext object.
    Hashtable properties = new Hashtable(2);

    // CHANGE these to match Geronimos JNDI service

    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
    properties.put(Context.PROVIDER_URL, "ejbd://127.0.0.1:4201");
    jndiContext = new InitialContext(properties);

    //[2] Look up connection factory and queue.
    connectionFactory = (ConnectionFactory)jndiContext.lookup("jms/ConnectionFactory");
    queue = (Queue)jndiContext.lookup("jms/Queue");

    //[3]
    // - Create connection
    // - Create session from connection; false means session is not transacted.
    // - Create sender and text message.
    // - Send messages, varying text slightly.
    connection = connectionFactory.createConnection();
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    messageProducer = session.createProducer(queue);

   //send a message
   TextMessage message = session.createTextMessage(this.jTextSend.getText()); 
   messageProducer.send(message); 

   //example for send some object
   //ObjectMessage message = session.createObjectMessage();
   //MyObj myObj = new MyObj ("Name"); //this class must be serializable 
   //message.setObject(myObj );
   //messageProducer.send(message);
}
catch(Exception ex)
{
   LOG.error(ex);
}
finally
{
     if(connection !=null)
     {
         try
         {
             connection.close();
         }
         catch(JMSException e)
         {
              LOG.error(e);
         }
     }
}