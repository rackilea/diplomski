public void deleteRole(String username, String role) {
    User user = userDao.findByUserName(username);
    Set<UserRole> userRoles = user.getUserRole();
    for (UserRole tempRole: userRoles) {
        if (tempRole.getRole().equals(role)){
            tempRole.setUser(null);
            sessionFactory.getCurrentSession().merge(tempRole);
        }
    }
}