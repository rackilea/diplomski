DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference locationsRef = rootRef.child("Locations");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            LocationContent lc = ds.child("South Bound").getValue(LocationContent.class);
            Log.d(TAG, lc.getLatitude(), ", " + lc.getLongitude());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
locationsRef.addListenerForSingleValueEvent(valueEventListener);