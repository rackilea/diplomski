DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference yourRef = rootRef.child("app_title").child("microDoctor").child("symptomList").child("Abdominal Cramps").child("Diarrhea").child("Vomiting");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String disease = ds.child("disease").getValue(String.class);
        Log.d("TAG", disease);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
yourRef.addListenerForSingleValueEvent(eventListener);