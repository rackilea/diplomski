public User createUser(final String userFirstName, final String userLastName, final String roleName) {

    Role role = roleDao.findByName(roleName);

    if(role == null) {

        role = new Role(roleName);
        roleDao.save(role);
    }

    final User user = new User(userFirstName, userLastName);
    user.addRole(role);
    userDao.save(user);

    return user;
}