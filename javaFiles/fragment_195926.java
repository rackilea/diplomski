DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference();
usersRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
            System.out.println(userSnapshot.getKey());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
}