DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference businessRef = rootRef.child("Discount").child("Business");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String altro = ds.child("Altro").getValue(String.class);
            String cognome = ds.child("Cognome").getValue(String.class);
            String informazioni = ds.child("Informazioni").getValue(String.class);
            String nome = ds.child("Nome").getValue(String.class);
            Log.d("TAG", altro + " / " + cognome + " / " + informazioni + " / " + nome);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
businessRef.addListenerForSingleValueEvent(eventListener);