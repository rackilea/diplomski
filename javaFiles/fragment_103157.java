String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference animalsRef = rootRef.child("users").child(uid).child("animals");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Animal> animalList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Animal animal = ds.getValue(Animal.class);
            animalList.add(animal);
        }

        //Do what you need to do with the animalList
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
animalsRef.addListenerForSingleValueEvent(valueEventListener);