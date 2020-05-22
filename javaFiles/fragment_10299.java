List<UserPost> getAllPosts() {
    // issue all requests
    List<CompletableFuture<List<UserPost>>> postFutures = requestUsers()
            .toCompletableFuture()
            .thenApply(userRequest -> parseUsers(userRequest)
                    .stream()
                    .map(this::userPosts)
                    .collect(toList())
            ).join();


    // collect the results
    return postFutures.stream()
            .map(CompletableFuture::join)
            .flatMap(List::stream)
            .collect(toList());
}