@Stateless 
public class CustomerService { 

  @PersistenceContext 
  private EntityManager entityManager; 

  public void addCustomer(Customer customer) { 
    entityManager.persist(customer); 
  } 
}