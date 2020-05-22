mUserDatabase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

             //"DATES:"+dataSnapshot.getKey()

                for (DataSnapshot childDataSnapshot2 : childDataSnapshot.getChildren()) {

             // "MEDICINE NAME"+childDataSnapshot2.getKey()

                    arrayList.add(childDataSnapshot2.getKey());

             //"VALUES"+childDataSnapshot2.getValue()

                }
                }

        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });