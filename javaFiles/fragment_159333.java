// outside onCreate
List<UserInformation> users = new ArrayList<>();


mRefresh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        DatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listClean();
                FirebaseUser user = mAuth.getCurrentUser();
                userID = user.getUid();
                Lat = dataSnapshot.child("Users").child(userID).child("Coordenates/Rute/Lat").getValue(String.class);
                Lng = dataSnapshot.child("Users").child(userID).child("Coordenates/Rute/Lng").getValue(String.class);
                DataSnapshot dS = dataSnapshot.child("Coordenate").child(Lat).child(Lng);

                for(DataSnapshot Ds : dS.getChildren()) {
                    Object key = Ds.getKey();
                    String StringKey = String.valueOf(key);

                    // fetch the user Object based on key and add it to list
                    users.add(lidataSnapshot.child("Users").child(StringKey).getValue(UserInformation.class));
                }
                 // now display list with all user information 
                 customAdapter customAdapterIntent= new customAdapter(SearchActivity.this,
                                                                      R.layout.userslist,
                                                                      users);
                 mListView.setAdapter(customAdapterIntent);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SearchActivity.this,"Error 404",Toast.LENGTH_SHORT).show();

            }
        });
    }
});