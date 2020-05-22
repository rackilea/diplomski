rootReference.child(ConstantFields.DATABASE_USER_LIST).addValueEventListener(new ValueEventListener() {
        String temp;
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
            {
                temp = dataSnapshot1.child(ConstantFields.DATABASE_USER_NAME).getValue(String.class);
                userList.add(temp);
               if(adapter!=null){
                 adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });