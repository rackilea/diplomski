@Repository
@Transactional
public class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    private SessionFactory factory;

    public void persist(T entity) {
        Session session = factory.getCurrentSession();
        session.persist(entity);
    }

    @SuppressWarnings("unchecked")
    public T merge(T entity) {
        Session session = factory.getCurrentSession();
        return (T) session.merge(entity);
    }

    public void saveOrUpdate(T entity) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public void delete(T entity) {
        Session session = factory.getCurrentSession();
        session.delete(entity);
    }

}