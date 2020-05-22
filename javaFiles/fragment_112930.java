mQueryDatabase.startAt(oldestUserID).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        fetchData(dataSnapshot);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});