DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference historyRef = rootRef.child("History");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Ride ride = ds.getValue(Ride.class);

            Log.d(TAG, "Driver = " + ride.getDriver());
            Log.d(TAG, "Rating = " + ride.getRating());
            Log.d(TAG, "Rider = " + ride.getRider());
            Log.d(TAG, "Price = " + ride.getRidePrice());
            Log.d(TAG, "status = " + ride.getStatus());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
historyRef.addListenerForSingleValueEvent(valueEventListener);