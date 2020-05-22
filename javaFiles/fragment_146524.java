DatabaseReference data = FirebaseDatabase.getInstance().getReference().child("Subscription");
data.orderByChild("name").equalTo(ABC).addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
      public void onDataChange(DataSnapshot dataSnapshot) {
      for(DataSnapshot data: dataSnapshot.getChildren()){
            data.getRef().removeValue();

                  }

            }

        @Override
       public void onCancelled(DatabaseError databaseError) {

               }
          });