public Set<User> getUsers() {
    if (users == null) {
        users = new HashSet<User>();
    }
    return users;
}