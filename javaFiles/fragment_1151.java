ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int total = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String amount = ds.child("amount").getValue(String.class);
            int value = Integer.valueOf(amount.replace(" Rs.", ""));
            total =+ value;
        }
        Log.d("TAG", String.valueOf(total) + " Rs.");
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
your_database_reference.addListenerForSingleValueEvent(eventListener);