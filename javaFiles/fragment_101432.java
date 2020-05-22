DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("users");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String fullName = ds.child("FullName").getValue(String.class);
            Log.d("TAG", fullName);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
usersRef.addListenerForSingleValueEvent(valueEventListener);