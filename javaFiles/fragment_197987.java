Properties props = new Properties();            
props.put(Context.INITIAL_CONTEXT_FACTORY,
             "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
    //props.put(Context.PROVIDER_URL,"vm://localhost");//Either this or below
    props.put(Context.PROVIDER_URL,"tcp://localhost:65432"); 
    props.put("queue.SendReceiveQueue",
         "org.apache.geronimo.configs/activemq-ra/JCAAdminObject/SendReceiveQueue");

    InitialContext context = new InitialContext(props);   
    QueueConnectionFactory connectionFactory = (QueueConnectionFactory)context.lookup
                                                               ("ConnectionFactory");
    Queue q = (Queue) context.lookup("SendReceiveQueue");
    System.out.println("conn is : "  + connectionFactory.getClass().getName());
    System.out.println("queue is : " + q.getQueueName());