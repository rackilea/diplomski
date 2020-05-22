public Observable<List<Posts>> getPostsForUser(User user) {
    return Observable
            .from(user.posts)
            .flatMap(this::getPost)
            .toList();
}