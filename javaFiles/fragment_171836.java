FirebaseDatabase database = FirebaseDatabase.getInstance();

DatabaseReference leaf1RRef = database.getReference("leaf1").child("r");
leaf1RRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Integer red = dataSnapshot.getValue(Integer.class);
        leaf1R=red;
        leaf1RRef.setValue(255);
        Log.d("MyLeaf", "Put max value");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("MyLeaf", "Put old value");
        leaf1RRef.setValue(leaf1R);
    }
    @Override
    public void onCancelled(DatabaseError error) {
        Log.w("MyLeaf", "Failed to read value.", error.toException());
    }
});