Results results;
String name, score;
private void fetchResults() {
    mDatabaseReference.child("Users").child(id).child("Quiz").child("Results").child(id).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
             for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                 name = childDataSnapshot.getKey().toString();
                 score = childDataSnapshot.child(name).getValue());
                 results = new Results(user, score);
                 resultsList.add(results);
                 mAdapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {
            throw databaseError.toException();
        }
    });
}