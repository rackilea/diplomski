DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
DatabaseReference users = reference.child("users");
users.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            if (snapshot.child("zhdl21dsa").exists()) {
                // run some code
            }else{

            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });