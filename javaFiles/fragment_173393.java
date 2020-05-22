String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
current_user_db.addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {
    String testData = dataSnapshot.child("testData").getValue(String.class);
 }

 @Override
 public void onCancelled(DatabaseError databaseError) {

    }
});