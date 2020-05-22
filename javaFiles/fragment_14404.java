ref.addValueEventListener(new ValueEventListener() {
    public void onDataChange(DataSnapshot dataSnapshot) {
        System.out.println(dataSnapshot.getValue()); 
    }

    public void onCancelled(DatabaseError databaseError) { }
});
ref.setValue(ServerValue.TIMESTAMP);