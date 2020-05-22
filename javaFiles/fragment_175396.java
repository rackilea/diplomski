@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getCustomers() {
        Query<Customer> query =
                (Query<Customer>) entityManager.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }
}