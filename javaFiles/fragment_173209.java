databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        StateDetails stateDetails = dataSnapshot.getValue(StateDetails.class);
        methodThatDoesSomething(stateDetails); //Method call

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});

private void methodThatDoesSomething(StateDetails stateDetails) {
    //Do what you need to do with your stateDetails object
}