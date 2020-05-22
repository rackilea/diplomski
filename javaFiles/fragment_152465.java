Chat chat = connection.getChatManager().createChat(to, this);
Message message = new Message(to, Message.Type.chat);
message.setBody("hello");
message.setProperty(prop0, val0);
message.setProperty(prop1, val1);
chat.sendMessage(message)