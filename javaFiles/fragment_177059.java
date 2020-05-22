MessageFactory messageFactory; //Injected 
...
MessageModel messageModel = getMessageFromAnAPI();

Message message = messageFactory.getMessage(messageModel);
message.manageMessage(messageModel);