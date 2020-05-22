// Create JMS objects
      connection = cf.createConnection();
      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      // Create queue destination 
      Destination queDest= session.createQueue(que);

      // Create consumer with selector
      String selector = "category='bucket1'";         
      MessageConsumer cons= session.createConsumer(queDest, selector);

      connection.start();
      // receive messages
      Message inMessage = cons.receive(5000);