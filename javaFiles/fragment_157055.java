DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("actors").orderByChild("image");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String image = ds.child("image").getValue(String.class);
            Log.d(TAG, image);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);