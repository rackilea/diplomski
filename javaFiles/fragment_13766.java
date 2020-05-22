private String getUserName(String uid) {
    Log.d("TAG", "Before attaching the listener!");
    databaseReference.child(String.format("users/%s/name", uid)).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // How to return this value?
            dataSnapshot.getValue(String.class);
            Log.d("TAG", "Inside onDataChange() method!");
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    });
    Log.d("TAG", "After attaching the listener!");
}