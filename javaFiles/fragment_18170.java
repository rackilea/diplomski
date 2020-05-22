package my.pkg;
// Imports etc

@Repository
public class Init {

    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[] { "Spring_Hibernate.xml" });
        Init init = context.getBean(Init.class);
        init.addUser();
    }

    @Transactional
    private void addUser() {
        Session session = sessionFactory.getCurrentSession();

        User user = new User();
        user.setName("123");
        session.save(user);
        // session.close(); DON'T NEED THESE!
        // sf.close();
    }
}