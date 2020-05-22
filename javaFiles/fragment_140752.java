public class IDaoImpl implements IDao {

    private final SessionFactory sessionFactory;

    @Inject
    public IDaoImpl(@Named("SessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}