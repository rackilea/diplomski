private void append_chat_conversation(DataSnapshot dataSnapshot) {
        chatList.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Log.e("Chat details: ", String.valueOf(ds));
            chat_username = dataSnapshot.child("username").getValue(String.class);
            chat_msg = dataSnapshot.child("message").getValue(String.class);

            Chat chat = new Chat(chat_username, chat_msg);
            chatList.add(chat);
            Log.e("Chat username: ", "" + chat_username);
            Log.e("Chat message: ", "" + chat_msg);
        }
        adapter.notifyDataSetChanged();
    }