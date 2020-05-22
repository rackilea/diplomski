List<UserBean> userBeanList= new  ArrayList<>();
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("PetchingBunyang").child(firebaseUser.getUid()).child("Requestor");
    reference.addSingleValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            //got all the list of the user ids 
            //userList is array of String which contains all userIds

            for (String userid : userList) {
                FirebaseDatabase.getInstance().getReference("Users").child(userid).addSingleValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //got all the list of the user ids
                        //
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });