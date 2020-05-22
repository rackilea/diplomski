private void VerifyUserExistance() {
            String currentUserID = mAuth.getCurrentUser().getUid();
            RootRef.child("Users").child(currentUserID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("name").exists()){
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    }
                    else {
Toast.makeText(MainActivity.this, "CALLED AGAIN", Toast.LENGTH_SHORT).show();
                        SendUserToSettingActivity();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }