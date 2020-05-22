Query query = reference.orderByChild("postid").equalTo("-LzNDAXtnT6NXYK2XYPK");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            double latitude = ds.child("location").child("latitude").getValue(Double.class);
            double longitude = ds.child("location").child("longitude").getValue(Double.class);
            Log.d(TAG, latitude + ", " + longitude);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);