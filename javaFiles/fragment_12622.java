ref1.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
             for(DataSnapshot datas: dataSnapshot.getChildren()){
            key = datas.getKey();
            System.out.println(key);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });