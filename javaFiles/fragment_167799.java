// OPEN CONNECTION AND CREATE SESSION
..
TemporaryQueue tempQueue = session.createTemporaryQueue();
msg.setJMSReplyTo(tempQueue);
// SEND MESSAGE
..
MessageConsumer mc = session.createConsumer(tempQueue);
Message retMsg = mc.receive(); //WAITING FOR A RESPONSE..