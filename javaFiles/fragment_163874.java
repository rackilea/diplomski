final int total = memberListByNumber.size();
for (String memberByNumber : memberListByNumber) {
    mFirebaseDatabaseReference
            .child("userUidsByNumber/")
            .child(memberByNumber)
            .addValueEventListener(new ValueEventListener() {
        int n = total;
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                String userUid = dataSnapshot.getValue().toString();
                memberList.add(userUid);
                if (--n <= 0) Log.d("LOL", "ContactsAdapter: " + memberList);
            } else {
                Snackbar.make(view, R.string.user_does_not_exist, Snackbar.LENGTH_LONG).show();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Snackbar.make(view, R.string.error, Snackbar.LENGTH_LONG).show();
        }
    });
}