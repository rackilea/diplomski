mDatabase = FirebaseDatabase.getInstance().getReference();
firebaseuser=FirebaseAuth.getInstance().getCurrentUser();
id=firebaseuser.getUid();

mDatabase.child("users").child(id).addValueEventListener(new ValueEventListener() {

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        UserInformation user= dataSnapshot.getValue(UserInformation.class);