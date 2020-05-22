final Chat chat = ChatManager.getInstanceFor(connection).chatWith(jid);

Message newMessage = new Message(jid, Message.Type.chat);
newMessage.setBody(message);

chat.send(newMessage);