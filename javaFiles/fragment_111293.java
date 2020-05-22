Connection<Conversation> conversations = facebookClient.fetchConnection("me/conversations", Conversation.class);
     for(List<Conversation> conversationPage : conversations) {
        for(Conversation conversation : conversationPage) {
          String id = conversation.getId();
          Connection<Message> messages = facebookClient.fetchConnection(id + "/messages", Message.class, Parameter.with("fields", "message,created_time,from,id"));
        }
     }