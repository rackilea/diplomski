DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();
Query lastQuery = dbReference.child("User").child("Location").orderByKey().limitToLast(1);
lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            double lat = ds.child("latitude").getValue(Double.class);
            double lng = ds.child("longitude").getValue(Double.class);
            LatLng prevloc = new LatLng(lat, lng);
            Log.d(TAG, lat + ", " + lng);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});