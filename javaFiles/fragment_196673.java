public class CheckUser {
    private final UserDao userDao;

    public CheckUser (final UserDao usedDao) {
        this.userDao = userDao;
    }

    public IUser getExistingUser() {
        if (userDao == null) {
            throw new RuntimeException("userDao is null");
        }
        IUser existingUser = userDao.getExistingUser();
        if (existingUser == null) {
            throw new RuntimeException("ExistingUser is null");
        }
        return existingUser;
    }
}