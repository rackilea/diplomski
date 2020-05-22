databaseReference.child(String.format("users/%s/name", uid)).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // How to return this value?
        if(dataSnapshot != null) {
            System.out.println(dataSnapshot.getValue(String.class));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});