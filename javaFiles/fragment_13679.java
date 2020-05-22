public void receiveChat(DataSnapshot dataSnapshot) {

        Iterator i = dataSnapshot.getChildren().iterator();
        while (i.hasNext()) {

            String message = (String) ((DataSnapshot) i.next()).getValue();
            String uname = (String) ((DataSnapshot) i.next()).getValue();
            ChatListManager chatList = new ChatListManager(uname,message);

            chatListArr.add(chatList);
        }
    }