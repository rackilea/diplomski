DatabaseReference db=FirebaseDatabase.getInstance().getReference().child("uploads");
   db.orderByChild("username").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
              String usernames=dataSnapshot.child("username").getValue().toString();

            }