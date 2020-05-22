DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference fRef = rootRef.child("F-5");
Query query = fRef.orderByChild("HotelTypeTwo").equalTo("Desi");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String hotelName = ds.getKey();
            Log.d(TAG, hotelName);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);