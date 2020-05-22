DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference studentsRef = rootRef.child("students");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String studentName = ds.child("studentName").getValue(String.class);
            Log.d("TAG", studentName);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
studentsRef.addListenerForSingleValueEvent(valueEventListener);