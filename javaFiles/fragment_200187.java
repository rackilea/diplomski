DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("comments").child(pollid).orderByChild("time");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Comment> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Comment comment = ds.getValue(Comment.class);
            commentList.add(comment);
        }

        //Do what you need to do with your list
        //Pass the list to the adapter and set the adapter
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
query.addListenerForSingleValueEvent(valueEventListener);