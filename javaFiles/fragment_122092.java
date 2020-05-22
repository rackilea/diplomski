lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            final String selectedFromList = (String)lists.getItemAtPosition(i);
            db= FirebaseDatabase.getInstance().getReference().child("Users");
            db.orderByChild("username").equalTo(selectedFromList).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot data: dataSnapshot.getChildren()){
                            String ids=datas.getKey();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }
    });