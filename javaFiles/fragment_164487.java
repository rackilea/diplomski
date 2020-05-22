DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Data");

        Query query = databaseReference.orderByChild("name")
             .startAt(mSearchText)
             .endAt(mSearchText+"\uf8ff");

        query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot data:dataSnapshot.getChildren()){

                         String name = data.child("name").getValue().toString();
                         String priority = data.child("Priority").getValue().toString();

                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });