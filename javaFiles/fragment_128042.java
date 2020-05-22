public class UserService {

    @Inject private UserDao userDao;

    public List<User> getUsersWithIds(List<Integer> userIds) {
        List<User> users = userDao.loadUsersWithIds(userIds);
        Ordering<User> orderById = Ordering.explicit(userIds).onResultOf(User::getId);
        return orderById.immutableSortedCopy(immutableSortedCopy(users));
    }

}