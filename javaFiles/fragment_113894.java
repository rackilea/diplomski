public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(ID id, LockModeType lock) {
        return em.find(entityClass, id, lock);
    }

    @Override
    public void save(T entity) {
        em.persist(entity);

    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }
.
.
.
}