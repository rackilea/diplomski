ArrayList<String> listOfSomething = new ArrayList<String>();
DatabaseReference ref=  FirebaseDatabase.getInstance().getReference("Medication_plan");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (String s: list) {
            listOfSomething.add(dataSnapshot.child("s").child("comment").getValue(String.class));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.w(TAG, "onCancelled", databaseError.toException());
    }
});