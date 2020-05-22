ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);

    // Getting JMS connection from the server
    ConnectionFactory connectionFactory= activeMQConnectionFactory;

    Connection connection = connectionFactory.createConnection();

    // Creating session for sending messages
    Session session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);


    // Getting the queue 'TESTQUEUE'
    Destination destination = session.createQueue("queue_name");

    // MessageConsumer is used for receiving (consuming) messages

    MessageConsumer consumer = session.createConsumer(destination);

    connection.start();        

    // Here we receive the message.
    // By default this call is blocking, which means it will wait
    // for a message to arrive on the queue.
    Message message= consumer.receive(500);
    while(message!= null)
    {

        // There are many types of Message and TextMessage
        // is just one of them. Producer sent us a TextMessage
        // so we must cast to it to get access to its .getText()
        // method.
        if (message instanceof TextMessage) 
        {
            TextMessage textMessage = (TextMessage) message;
       //     BytesMessage Byte

            System.out.println("Received message '"+ textMessage.getText() + "'");
        }           
        message = consumer.receive(1);
      }