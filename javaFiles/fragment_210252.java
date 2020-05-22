public Observable<List<User>> getPopulatedUser() {
    return apiService.getUsers()
            .flatMap(userResponse -> Observable.from(userResponse.users).toList())
            .flatMap(Observable::from)
            .flatMap(user -> getPostsForUser(user)
                    .map(posts -> {
                        user.setPosts(posts);
                        return (User) user;
                    })
            ).toList();
}