DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(userID).child("vouchers");
mDatabaseUsers.addValueEventListener(new ValueEventListener() {
  @Override
public void onDataChange(DataSnapshot dataSnapshot) {

   String values     = dataSnapshot.child("april19").getValue(String.class);
   String boolValues = dataSnapshot.child("march19").getValue(String.class);
}

  @Override
public void onCancelled(DatabaseError databaseError) {

  }
});