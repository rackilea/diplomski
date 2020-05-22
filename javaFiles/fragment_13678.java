public void receiveChat(DataSnapshot dataSnapshot) {


        Iterator i = dataSnapshot.getChildren().iterator();
        ChatListManager chatList = new ChatListManager();
        while (i.hasNext()) {


            chatList.setChatMessage((String) ((DataSnapshot) i.next()).getValue());
            chatList.setChatUsername((String) ((DataSnapshot) i.next()).getValue());

            chatListArr.clear();
            chatListArr.add(chatList);

        }