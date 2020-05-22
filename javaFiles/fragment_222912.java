DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference deviceTokenRef = rootRef.child("chatmessage").child("devicetoken");
Query query = deviceTokenRef.orderByKey().limitToLast(1);
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String key = ds.getKey();
            Log.d("TAG", key);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(eventListener);