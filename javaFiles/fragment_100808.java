HashMap<Integer, User> users = new HashMap<>();

for(Post post : posts) {
    int userId = post.getPostAuthorId();
    if(users.get(userId) != null) {
        users.get(userId).addPost(post);
    }
    else {
        users.put(userId, new User(userId));
    }
}