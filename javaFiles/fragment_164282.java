@Component
public abstract class RootDAOImpl<T> extends HibernateDaoSupport implements RootDAO<T> {


    protected Logger logger = LoggerFactory.getLogger(getClass());
    private Class<T> clazz;

    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    public RootDAOImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    public void delete(String id) {
        getHibernateTemplate().delete(new FbUser(id));
    }

    public void markAsDeleted(T entity) {
        // Mark entity as deleted
        try {
            Method setDeletedMethod = clazz.getDeclaredMethod("setDeleted", Boolean.class);
            setDeletedMethod.invoke(entity, true);
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // actually delete
        // getHibernateTemplate().delete(entity);
    }

    @Override
    public void deleteAll(Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }

    @Override
    public void saveOrUpdateAll(Collection<T> entities) {
        getHibernateTemplate().saveOrUpdateAll(entities);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Serializable id) {
        return (T) getHibernateTemplate().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T load(Serializable id) {
        return (T) getHibernateTemplate().load(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find(String hql) {
        return (List<T>) getHibernateTemplate().find(hql);
    }

    @Override
    public Object execute(HibernateCallback action) {
        return getHibernateTemplate().execute(action);
    }


    .
    .
    .

}