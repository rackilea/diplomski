String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);
dbRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
           String post = dataSnapshot.child("post").getValue(String.class);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });