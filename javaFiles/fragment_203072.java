long cutoff = new Date().getTime() - TimeUnit.MILLISECONDS.convert(30, TimeUnit.DAYS);
Query oldItems = ttlRef.orderByChild("timestamp").endAt(cutoff);
oldItems.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        for (DataSnapshot itemSnapshot: snapshot.getChildren()) {
            itemSnapshot.getRef().removeValue();
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});