public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void addUser(UserMap userMap) {
        getHibernateTemplate().save(userMap);
    }
    @Override
    public List<User> findAllUser() {
        return getHibernateTemplate().find("from User");
    }
    @Override
    public void deleteUser(UserMap user) {
        getHibernateTemplate().delete(user);
    }
    @Override
    public void updateUser(UserMap user) {
        getHibernateTemplate().update(user);
    }
}