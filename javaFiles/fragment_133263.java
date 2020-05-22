DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference barcodeRef = rootRef.child("Items").child("1234567781");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long itemQuantity = dataSnapshot.child("itemQuantity").getValue(Long.class);
        Log.d(TAG, String.valueOf(itemQuantity));

        //Do what you need to do with itemQuantity
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
barcodeRef.addListenerForSingleValueEvent(valueEventListener);