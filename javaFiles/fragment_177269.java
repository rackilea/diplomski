public Set<User> getAllUsers() {
    Set<User> allUsers = new HashSet<>();
    allUsers.addAll(projectLeaders);
    allUsers.addAll(projectUsers);
    return allUsers;
}