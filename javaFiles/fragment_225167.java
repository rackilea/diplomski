firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        if(firebaseAuth.getCurrentUser()!=null) {
            final FirebaseDatabase database =FirebaseDatabase.getInstance();
            DatabaseReference myref=database.getReference("Users").child(firebaseAuth.getUid());
            myref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserModel userModel=  dataSnapshot.getValue(UserModel.class);
                    System.out.println(userModel.getName());
                    Common.setSpanString("Hey, ", userModel.getName(), txt_user);
                    currentUser=userModel;
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(HomeActivity.this, ""+databaseError.getCode(), Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            UserModel userModel = new UserModel(uid,name,address,phone,email,password);
            userModel.setName("Example Name");
            Common.setSpanString("Hey, ", userModel.getName(), txt_user);
        }