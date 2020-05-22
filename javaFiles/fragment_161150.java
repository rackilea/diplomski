DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query levelQuery = rootRef.child("users").orderByChild("level").equalTo(1);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String username = ds.child("username").getValue(String.class);
            Log.d(TAG, username);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
levelQuery.addListenerForSingleValueEvent(valueEventListener);