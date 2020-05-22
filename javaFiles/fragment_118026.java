public class UserServiceImpl implements UserService {
    private UserDAO userDao;    // injected by Spring

    @Transactional
    public void changeUserName(String name) {
        User user = userDao.getGiUser();
        user.setName(name);
        // I can't remember if this saveUser() call is required, or if
        // Hibernate will automatically pick up the changes and save the 
        // user object
        userDao.saveUser(user);
    }
}