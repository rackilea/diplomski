Set<User> users = mySite.getUsers();
if (users == null) {
    users = new HashSet<User>();
}
users.add(newUser);
mySite.setUsers(users);