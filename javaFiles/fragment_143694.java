DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference messagesRef = rootRef.child("messages");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            for(DataSnapshot dSnapshot : ds.getChildren()) {
                String userName = dSnapshot.child("userName").getValue(String.class);
                Log.d("TAG", userName);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
messagesRef.addListenerForSingleValueEvent(eventListener);