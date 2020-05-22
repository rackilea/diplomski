mDatabase = FirebaseDatabase.getInstance().getReference();
mDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        firebaseuser=FirebaseAuth.getInstance().getCurrentUser();
        id=firebaseuser.getUid();

       for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren() ){
           UserInformation user= dataSnapshot1.child("user").child(id).getValue(UserInformation.class);

        }