public class HibernateDaoImpl implements HibernateDao {

    private final JPAApi JPA_API;

    @Inject
    public HibernateDaoImpl(JPAApi api) {
        this.JPA_API = api;    
    }


    // (...)

    @Override
    public <T> List<T> executeQueryForObject(String sql, Map<String, Object> map)
            throws PersistenceException {
        EntityManager em = JPA_API.em("default");
        try {
            Query query = prepareQuery(em, sql, map);
            List<T> objectList = query.getResultList();
            return objectList;
        } finally {
            em.close();
        }
    }
    // (...)
}