public List<Comment> getComments(Post post) {
    List<Comment> fullComments = new ArrayList<>();
    try {
        // get first few comments using getComments from post
        PagableList<Comment> comments = post.getComments();
        Paging<Comment> paging;
        do {
            for (Comment comment: comments)
                fullComments.add(comment);

            // get next page
            // NOTE: somehow few comments will not be included.
            // however, this won't affect much on our research
            paging = comments.getPaging();
        } while ((paging != null) && 
                ((comments = fb_.fetchNext(paging)) != null));

    } catch (FacebookException ex) {
        Logger.getLogger(Facebook.class.getName())
                .log(Level.SEVERE, null, ex);
    }

    return fullComments;
}