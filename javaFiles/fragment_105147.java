public User findOneWithRole(int id) {
    User user = findById(id);
    List<Role> roles =  roleDao.findByUser(id);
    user.setRoles(roles); // <-- THIS LINE
    return user;
}