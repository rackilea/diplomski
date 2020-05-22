DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference studentsRef = rootRef.child(teachers).child(teacherId).child("students");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String studentName = ds.getValue();
            Log.d("TAG", studentName);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
studentsRef.addListenerForSingleValueEvent(valueEventListener);