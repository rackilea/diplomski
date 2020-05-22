mDatabaseReference.child("Profilo").addListenerForSingleValueEvent(new ValueEventListener() {//to retrieve data
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
         for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
              String names=dataSnapshot1.child("nome").getValue().toString();
              nomeProfilo.setText(names);


                }
           }
         @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });