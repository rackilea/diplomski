@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    public UserDaoImpl() {
    }

    @PostConstruct
    public void init() {
        this.session = sessionFactory.getCurrentSession();
    }
    ...
}