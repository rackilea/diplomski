DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("User").child("doctor");


dbRef.orderByChild("Spciality").equalTo("Pathologist").addListenerForSingleValueEvent(new ValueEventListener() { 
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
           for(DataSnapshot datas: dataSnapshot.getChildren()){
                String firstName=datas.child("Firstname").getValue().toString();
                String lastName=datas.child("Lastname").getValue().toString();
              }
            }
        @Override
      public void onCancelled(DatabaseError databaseError) {

           }
       });