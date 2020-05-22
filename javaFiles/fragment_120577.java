query.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
            rank = "" + dataSnapshot1.child("rank").getValue();
            profilePicture = "" + dataSnapshot1.child("image").getValue();
            username = "" + dataSnapshot1.child("username").getValue();

            chatsItemArrayList.add(new ChatsItem(getProfilePicture(), title, date, speaks, description, getUsernameText(), getRankText(), upvotes, views, picture));

        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException();
    }
});