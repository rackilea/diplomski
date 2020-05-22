String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference uidRef = rootRef.child("favoritos").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Perfil> list = new ArrayList<>();
        for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
            for(DataSnapshot ds : dSnapshot.getChildren()) {
                Perfil perfil = ds.getValue(Perfil.class);
                Log.d("TAG", perfil.getTitulo());
            }
        }

        //Set the list to adapter
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(valueEventListener);