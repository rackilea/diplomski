public class UserDAO extends AbstractDAO<User> {
    private final SessionFactory sessionFactory;

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public UserDAO(SessionFactory sessionFactory)
    {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieve all users.
     *
     * @return
     */
    public List findAll()
    {
        return criteria().list();
    }

    /**
     * Finds a user by email. Used for authorization.
     *
     * @param email
     * @return
     */
    public User getByEmail(String email)
    {
        Session session = sessionFactory.openSession();
        try {
            User user = (User) session.createCriteria(User.class).add(Restrictions.eq("email", email))
                .uniqueResult();
            Hibernate.initialize(user.getRoles());
            return user;
        } finally {
            session.clear();
        }
    }
}