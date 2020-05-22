DatabaseReference myRef = database.getReference("user_info");
 DatabaseReference myRef1=myRef.child(userid);
 myRef1.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue(String.class);
                String email = dataSnapshot.child("email").getValue(String.class)
  }
});