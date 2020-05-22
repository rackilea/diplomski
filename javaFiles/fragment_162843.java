DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference userEmailDatabaseReference = rootRef.child("usersEmail").child(particularUserEmail);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (!dataSnapshot.exists()) {
            Log.d("TAG", "User does not exist!");
        } else {
            Log.d("TAG", "User exists!");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
userEmailDatabaseReference.addListenerForSingleValueEvent(valueEventListener);