Observable<Post> transform(PostResponse postResponse) {
    return userRepository.user(postResponse.getUserId())
        .map(user -> parseResponse(parseResponse, user));
}


Post parseResponse(PostResponse response, User user) {
    final Post post = new Post(postResponse.getId());
    post.setTitle(postResponse.getTitle());
    post.setBody(postResponse.getBody());   
    post.setUser(user);

    return post;
}