DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference locationsRef = rootRef.child("Locations");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            double lat = ds.child("South Bound").child("Latitude").getValue(Double.class);
            double lng = ds.child("South Bound").child("Longitude").getValue(Double.class);
            Log.d(TAG, lat, ", " + lng);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
locationsRef.addListenerForSingleValueEvent(valueEventListener);