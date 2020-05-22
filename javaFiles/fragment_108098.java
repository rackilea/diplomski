public List<Comment> getUserCommentItems() {
    if (userCommentItems == null) {
        getUserPagingInfo();
        List<Comment> comments = jpaController.findAll();
        for (Iterator<Comment> iterator = comments.iterator(); iterator.hasNext();){
                userComments = iterator.next();
                if (!userComments.getMovie().equals(movieController.getMovie()){
                    iterator.remove();
                }
            }
        userCommntItems = comments;
    }
    return userCommentItems ;
}