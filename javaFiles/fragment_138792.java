Query postQuery=postRef.orderByChild("uid").equalTo(currentUserId);
        postQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Log.i("Post",snapshot.getKey());
                    postRef.child(snapshot.getKey()).child("profile_image").setValue(profile_img);
                    postRef.child(snapshot.getKey()).child("fullname").setValue(fullname);




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });