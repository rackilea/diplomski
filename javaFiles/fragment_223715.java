DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("postagens-curtidas");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            long qtdCurtidas = ds.child("qtdCurtidas").getValue(Long.class);
            Log.d(TAG, "qtdCurtidas: " + qtdCurtidas);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
ref.addListenerForSingleValueEvent(valueEventListener);