if (result != null && result.moveToFirst()){
    do {
       Post post = new Post();
       post.setPostId(result.getInt(0));
       posts.add(post);
       ....
    } while (result.moveToNext());
}