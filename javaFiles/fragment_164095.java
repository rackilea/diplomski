public class UserDAO extends BaseDAO<User> {

    private static final String USER_TABLE_NAME = "t_user";
    private static final String userFields[] = {"name", "birthday", "email", "password", "role", "enabled"};

    public UserDAO() {
        super(User.class, USER_TABLE_NAME, Arrays.asList(userFields));
    }