final DatabaseReference table_user = database.getReference("User");


table_user.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()){
           String plate = ds.child("carPlateNo").getValue().toString();
           String email = ds.child("email").getValue().toString();
               //etc
        }
    }