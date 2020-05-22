FirebaseDatabase.getInstance().getReference().child("Time/2019/April/02").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount()==100){

                 //code here
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });