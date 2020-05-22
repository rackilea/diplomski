DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference comingSoonPagesRef = rootRef.child("comingSoonPages");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("name").getValue(String.class);
            Log.d("TAG", name);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
comingSoonPagesRef.addListenerForSingleValueEvent(eventListener);