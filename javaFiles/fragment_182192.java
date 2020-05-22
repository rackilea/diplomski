@Transactional
@Repository
public class CanvasDAOImpl implements CanvasDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public CanvasDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

   @overrride
   public returnType methodName(params..){
        Session session = this.sessionFactory.getCurrentSession();
        // Do stuff with the session.
    }
}