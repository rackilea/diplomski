ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        UserModelClass userModelClass = dataSnapshot.getValue(dataSnapshot.class);
        String name = userModelClass.getName();
        String sureName = userModelClass.getSureName();
        String date = userModelClass.getDate();
        String phoneNumber = userModelClass.getPhoneNumber();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
uidRef.addListenerForSingleValueEvent(eventListener);