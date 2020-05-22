DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference comingSoonPagesRef = rootRef.child("comingSoonPages");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            UpcomingProperty upcomingProperty = ds.getValue(UpcomingProperty.class);
            Log.d("TAG", upcomingProperty.getName());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
comingSoonPagesRef.addListenerForSingleValueEvent(eventListener);