public void addPostComment(final String name, final String email, final String body,
                           final String permalink) {
   Document post = findByPermalink(permalink);
   List<Document> comments = null;
   Document comment = new Document();
   if(post != null){
        comments = (List<Document>)post.get("comments");
        comment.append("author",name).append("body", body);

        if(email != null){
            comment.append("email", email);
        }
        comments.add(comment);
        postsCollection.updateOne(new Document("permalink",permalink), 
                                new Document("$set",new Document("comments",comments)));

        }
}