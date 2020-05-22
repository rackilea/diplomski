public void readData(MyCallback myCallback) {
    databaseReference.child(String.format("users/%s/name", uid)).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String value = dataSnapshot.getValue(String.class);
            myCallback.onCallback(value);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    });
}