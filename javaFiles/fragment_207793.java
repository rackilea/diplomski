demoRef.child("date").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        date = dataSnapshot.getValue(String.class);

Toast.makeText(getContext() , date , Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
    }
});