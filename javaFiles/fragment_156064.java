DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
dbRef.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        //Loop through the retrieved user data
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            User user = snapshot.getValue(User.class);
            System.out.println(user.name);
        }
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {}
});