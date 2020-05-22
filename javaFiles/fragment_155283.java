public static ArrayList<Comments> getComments() {
    ArrayList<Comments> commentsList = new ArrayList<>();

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Comments");

    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            commentsList.clear();

            for (DataSnapshot shot : snapshot1.getChildren()) {
                Comments comments = shot.getValue(Comments.class);
                commentsList.add(comments);
            }

            // Invoke the function here to get the values now
            nowCreateArrayListOfObjects();
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    });

    return commentsList;
}