public void readData(MyCallback myCallback) {
    mCurrentUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String university = dataSnapshot.child("university").getValue().toString();
            String groupid = dataSnapshot.child("groupid").getValue().toString();
            //Having acquired university and group ID, now we can get reference to group members list
            mMembersDatabase = FirebaseDatabase.getInstance().getReference().child("Universities").child(university).child("Groups").child(groupid).child("Members");
            myCallback.onCallback(mMembersDatabase);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    });
}