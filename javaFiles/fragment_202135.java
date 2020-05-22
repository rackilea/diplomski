if (mFirebaseUser != null) {
            currentUserID = mFirebaseUser.getUid();
        }
 UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");
     UsersRef.child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.exists())
                {   if (dataSnapshot.hasChild("fullname")){
                    String fullname = dataSnapshot.child("fullname").getValue().toString();
                    NavProfileUserName.setText(fullname);
                }if (dataSnapshot.hasChild("profileimages")) {
                    String image = dataSnapshot.child("profileimages").getValue().toString();
                    Picasso.with(MainActivity.this).load(image).placeholder(R.drawable.profile).into(NavProfileImage);

                }else {
                    Toast.makeText(MainActivity.this, "Profile name do not exists...", Toast.LENGTH_SHORT).show();
                }




                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });