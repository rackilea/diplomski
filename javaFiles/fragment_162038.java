List<Post> mPost;
     @Override
     public void onBindViewHolder(@NonNull final PostHolder postHolder, final int i) {
    String posid=mPost.get(i).getPostid();
    String lastname=mPost.get(i).getLastname();
    long timestamp=mPost.get(i).getTimestamp();
    // This will have the list of comments and the number of the comments 
    //you have
    long commentsNumber = 0
    if(mPost.get(i).getComments()!=null)
      commentsNumber=mPost.get(i).getComments().size();
        }