String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("users").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.child("Type").getValue(Long.class) == 1) {
            startActivity(new Intent(MainActivity.this, student.class));
        } else if (dataSnapshot.child("TYPE").getValue(Long.class) == 2) {
            startActivity(new Intent(MainActivity.this, teacher.class));
        } else if (dataSnapshot.child("TYPE").getValue(Long.class) == 3) {
            startActivity(new Intent(MainActivity.this, admin.class));
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);