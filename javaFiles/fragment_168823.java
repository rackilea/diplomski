DatabaseReference UserRef = database.getReference().child("User").child(userID);
UserRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()){
            User user = snapshot.getValue(User.class);
            String a = user.getUserID();

            UserList.add(user);

            Log.d(TAG, "2유저리퍼★who    "+a);
        }
        tripSearchAdapter2.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException();
    }
});