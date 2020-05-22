@Repository
public class UserDAOImpl extends RootDAOImpl<User> implements UserDAO{


    public UserDAOImpl() {
        super(User.class);
    }
}