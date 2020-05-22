DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("Users").orderByChild("Name");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<User> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("Name").getValue(String.class);
            String mail = ds.child("Email").getValue(String.class);
            String phone = ds.child("Phone").getValue(String.class);
            String id = ds.child("ID").getValue(String.class);

            User user = new User(mail, phone, name);
            //User user = new User(id, mail, phone, name);
            list.add(user);
        }
        Log.d("TAG", list.toString());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);