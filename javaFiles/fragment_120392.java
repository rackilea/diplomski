private void getData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference().child("Tweets");
        final DatabaseReference ref2 = firebaseDatabase.getReference().child("Users");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    for (final DataSnapshot ds : dataSnapshot.getChildren()) {
                        System.out.println("Selam" + ds.toString());
                        if (ds.child("authorId") != null) {
                            final String authorID = ds.child("authorId").getValue().toString();
                            final String id = ds.child("id").getValue().toString();
                            final String content = ds.child("content").getValue().toString();
                            final int likeNumber = Integer.parseInt(ds.child("likeNumber").getValue().toString());
                            final boolean isActive = Boolean.parseBoolean(ds.child("isActive").getValue().toString());

                            ref2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshotID) {
                                    if (dataSnapshotID.exists()) {
                                        for (DataSnapshot ds2 : dataSnapshotID.getChildren()) {
                                            if (ds2.child("id").getValue().toString().equals(authorID)) {
                                                System.out.println("AuthorID: " + authorID + " İsim: " + ds2.child("username").getValue().toString());
                                                tweets.add(new Tweet(id, R.drawable.ic_adb_black_24dp, ds2.child("username").getValue().toString(),
                                                        content, likeNumber, isActive));
                                                buildRecyclerView(); //add it here

                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseErrorID) {

                                }
                            });
                        }
                    }
                }
                else{
                    Log.i("Database: ","Fail");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }