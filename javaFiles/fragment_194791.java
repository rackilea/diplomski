DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference newRef = rootRef.child("new");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.child("mailID").getChildren()) {
            String email = ds.child("email").getValue(String.class);
            String name = ds.child("name").getValue(String.class);
            Log.d("TAG", email + " / " + name);
        }
        for(DataSnapshot ds : dataSnapshot.child("mailText").getChildren()) {
            String title = ds.child("title").getValue(String.class);
            String subject = ds.child("subject").getValue(String.class);
            Log.d("TAG", title + " / " + subject);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
newRef.addListenerForSingleValueEvent(valueEventListener);