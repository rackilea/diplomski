@Repository("userService")
public class DAOUser implements Serializable {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Transactional
    public void register(User user){
        // Acquire session
        Session session = sessionFactory.getCurrentSession();
        // Save employee, saving behavior get done in a transactional manner
        session.save(user);     
    }
}