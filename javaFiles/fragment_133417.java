Query query = FirebaseDatabase.getInstance().getReference("postId").orderByChild("timestamp").limitToFirst(100);

FirebaseRecyclerOptions<Posts> options =
        new FirebaseRecyclerOptions.Builder<Posts>()
                                   .setQuery(query, Posts.class)
                                   .build();