String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("AllChatMessages").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            for(DataSnapshot dSnapshot : ds.getChildren()) {
                for(DataSnapshot snap : dSnapshot.getChildren()) {
                    String key = snap.getKey();
                    Log.d("TAG", key);
                }
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(valueEventListener);