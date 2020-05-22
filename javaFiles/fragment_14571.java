TextMessage messageReceived = (TextMessage) messageConsumer.receive(5000);

System.out.println("Received message: " + messageReceived.getText());

messageReceived = (TextMessage) messageConsumer.receive(5000);

System.out.println("Received message: " + messageReceived.getText());