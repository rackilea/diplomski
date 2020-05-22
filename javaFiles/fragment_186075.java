private void getConversations(){

final DatabaseReference conversationRef = databaseReference.child("conversation").child(currentUser);

// Get event fired when new child added
conversationRef.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
        String ref= dataSnapshot.getKey();
        int position = userListRef.size();
        userListRef.add(position,ref);
        getDetailedConversations(position);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
            //Here no need to clear and reload
            //just find the user in list and update the corresponding object and call notifyDatasetChanged()

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {}

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

    @Override
    public void onCancelled(DatabaseError databaseError) {}


});