myRef.child("your_location").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        double latitude = dataSnapShot.getValue("Latitude", Double.class);
        double longitude = dataSnapShot.getValue("Longitude", Double.class);
        LatLng retrievedLang = new LatLng(latitude, longitude);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "loadLocation:onCancelled", databaseError.toException());
    }
})