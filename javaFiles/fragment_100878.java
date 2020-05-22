String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference medicinesRef = rootRef.child(uid).child("Medicines");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String key = ds.getKey();
            String altisgpt = ds.child("ALTISGPT").getValue(String.class);
            Log.d(TAG, key + " -> " + altisgpt);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
medicinesRef.addListenerForSingleValueEvent(valueEventListener);