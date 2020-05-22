final QueueReceiver queueReceiver = queueSession.createReceiver(queue);
queueConnection.start();

while (true) {
  Message message = queueReceiver.receive();
  // Process your message: insert the code from MyListener.onMessage here

  // Possibly add an explit message.acknowledge() here, 
  // if you want to make sure that in case of an exception no message is lost
  // (requires Session.CLIENT_ACKNOWLEDGE, when you create the queue session)

  // Possibly terminate program, if a certain condition/situation arises
}