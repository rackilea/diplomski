FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
mDatabaseReference.child("Profilo").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
     @Override
   public void onDataChange(DataSnapshot dataSnapshot) {
      String names=dataSnapshot1.child("nome").getValue().toString();
              nomeProfilo.setText(names);


                }
           }
         @Override
        public void onCancelled(DatabaseError databaseError) {

        }
   });