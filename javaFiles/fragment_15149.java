List<String> tokens=new ArrayList<String>();
Sender sender = new Sender(GOOGLE_SERVER_KEY);
Message message = new Message.Builder().timeToLive(30)
.delayWhileIdle(true).addData(GOOGLE_MESSAGE_KEY,
     userMessage).build();
    sender.send(message, tokens, 1);