DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child("Aleem");
databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
           String profilePic = dataSnapshot.child("profilePic").getValue(String.class);
           String password   = dataSnapshot.child("password").getValue(String.class);
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});