DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("UToouch");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String name = dataSnapshot.child("Name").getValue(String.class);
        String weight = dataSnapshot.child("Weight").getValue(String.class);
        Log.d(TAG, name + " / " + weight);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
ref.addListenerForSingleValueEvent(valueEventListener);