public void getPostId(String userId) {
    final String postId = "post";
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("AdUsersINFO").child(userId);
    rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            long c = snapshot.getChildrenCount();
            if(c==) postId = postId+"1";
            else postId = postId+ c+1;
        },

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
};