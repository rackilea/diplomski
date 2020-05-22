public Task<List<String>> getNames() {
TaskCompletionSource<String> task = new TaskCompletionSource<>();
DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("user");
            ref.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot

                           task.setResult(getAllNames((Map<String,Object>) dataSnapshot.getValue()));

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            //handle databaseError
                            task.setException(new RuntimeException());
                        }
                    });
    return task.getTask()

}