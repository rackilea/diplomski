mDatabase.child("beacons").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot beaconSnapshot: dataSnapshot.getChildren()) {
            EmBeacon mBeacon = beaconSnapshot.getValue(EmBeacon.class);
            Log.i(TAG, "onDataChange: "+mBeacon);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.w(TAG, "onCancelled:", databaseError.toException());
    }
});