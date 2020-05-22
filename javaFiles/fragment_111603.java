@Service
public class AnswerDAOReal extends EntityDAO<Answer, Integer> {

    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public AnswerDAOReal(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    private void openSession() {
        this.session = sessionFactory.openSession();
    }

}