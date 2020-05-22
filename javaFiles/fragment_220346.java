FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    firebaseDatabase.getReference("<top-level-key>")
            .child("L3l1...")
            .child("answers")
            .child("1")
            .addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //Returns a hashmap with keys of type answer and vote_count
                    Object value = dataSnapshot.getValue(); /
                    Object o = ((HashMap) value).get("answer");
                    String s = "";
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });