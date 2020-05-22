ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long count = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            long ratingg = ds.child("ratingg").getValue(Long.class);
            count = count + ratingg;
        }
        long avarage = count / dataSnapshot.getChildrenCount();
        Log.d("TAG", "avarage: " + avarage);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);