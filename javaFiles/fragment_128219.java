@Repository
 public class CustomerDetailsDAOImpl implements CustomerDetailsDAO {

@Autowired
SessionFactory sessionFactory;

@Override
@Transactional
public List<CustomerDetails> getCustomer(String customerPhone) {
    Session session = sessionFactory.openSession();

    Query q = session.createQuery("from CustomerDetails where customerPhone =:p");
    q.setParameter("p", customerPhone);

    CustomerDetails customer = q.getSingleResult();
    session.close();
    return customer;

}