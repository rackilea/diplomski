DatabaseReference root = FirebaseDatabase.getInstance().getReference();
DatabaseReference users = root.child("users");
users.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            if (snapshot.child("Michael").exists()) {
                // run some code
            }else{

            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });