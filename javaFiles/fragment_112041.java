DatabaseReference usersRef = usersDatabaseReference.child(userEmail);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (!dataSnapshot.exists()) {
            //create user
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
usersRef.addListenerForSingleValueEvent(valueEventListener);