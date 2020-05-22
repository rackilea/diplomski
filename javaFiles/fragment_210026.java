String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference geoFenceUidRef = rootRef.child("Geo-fence").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        double geoFenceLat = dataSnapshot.child("Latitude").getValue(Double.class);
        double geoFenceLng = dataSnapshot.child("Longitude").getValue(Double.class);
        Location geoFenceLocation = new Location("");
        geoFenceLocation.setLatitude(geoFenceLat);
        geoFenceLocation.setLongitude(geoFenceLng);
        Log.d(TAG, geoFenceLat + ", " + geoFenceLng);

        DatabaseReference propertyUidRef = rootRef.child("Property").child(uid);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    double propertyLat = ds.child("latitude").getValue(Double.class);
                    double propertyLng = ds.child("longitude").getValue(Double.class);
                    Log.d(TAG, propertyLat + ", " + propertyLng);

                    //Compare
                    Location propertyLocation = new Location("");
                    propertyLocation.setLatitude(propertyLat);
                    propertyLocation.setLongitude(propertyLng);
                    float distance = geoFenceLocation.distanceTo(propertyLocation);
                    Log.d(TAG, String.valueOf(distance));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        propertyUidRef.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
geoFenceUidRef.addListenerForSingleValueEvent(valueEventListener);