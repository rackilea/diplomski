ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<YourClass> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            YourClass yourClass = ds.getValue(YourClass.class);
            list.add(yourClass);
        }

        YourClass lastItem = list.get(list.size() - 1);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);