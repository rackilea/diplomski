DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference propertyImageRef = rootRef.child("Buy").child("1").child("propertyImage");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String url = ds.getValue(String.class);
            Log.d("TAG", url);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
propertyImageRef.addListenerForSingleValueEvent(valueEventListener);