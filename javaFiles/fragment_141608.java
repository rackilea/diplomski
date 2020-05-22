DatabaseReference chatReference = FirebaseDatabase.getInstance().getReference("chats");
chatReference.orderByChild("users/user1").equalTo(true).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot chat: dataSnapshot.getChildren()) {
                Log.d("TAG", chat.getKey());
                Chat chat = chat.getValue(Chat.class);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            throw databaseError.toException(); // don't ignore errors
        }
    });