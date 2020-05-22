databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(user != null){

                 if(dataSnapshot.child("userTypeId").getValue(String.class).equals(0))
                        // user type 1
                 else 
                       // user type 2

                finish();
                startActivity (intent);
               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled", databaseError.toException());
            }


        });