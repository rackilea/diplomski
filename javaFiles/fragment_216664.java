public class JpaAndJdbcDomainRepository implements DomainRepository{

    private JdbcTemplate template;
    private EntityManager entityManager;

    //Inject the JdbcTemplate (or the DataSource and construct a new JdbcTemplate)
    public DomainRepository(JdbcTemplate template){
        this.template = template;
    }

    //Inject the EntityManager
    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Execute a JPA query
    public DomainObject getDomainObject(Long id){
        return entityManager.find(id);
    }

    //Execute a native SQL Query
    public List<Map<String,Object>> getData(){
        return template.queryForList("select custom from my_data");
    }
}