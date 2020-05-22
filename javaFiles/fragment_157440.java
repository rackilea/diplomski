DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");

FirebaseAuth mAuth = FirebaseAuth.getInstance();

ref.child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.child("nombre_dons").getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled", databaseError.toException());
            }

   });