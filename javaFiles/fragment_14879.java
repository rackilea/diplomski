DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference campaignsRef = rootRef.child("campaigns");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            double latitude = ds.child("location").child("latitude").getValue(Double.class);
            double longitute = ds.child("location").child("longitute").getValue(Double.class);
            Log.d(TAG, latitude ", " + longitute);
            LatLng latLng = new LatLng(latitude, longitute);
            //Do what you need to do with your LatLng object
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
campaignsRef.addListenerForSingleValueEvent(valueEventListener);