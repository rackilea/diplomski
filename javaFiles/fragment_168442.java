@Stateless
public class EmployeeService {

  //The entity manager will be injected automatically  
  @PersistenceContext
  private EntityManager em;

  public Employee findEmployeeById(Long id) {
    return em.find(Employee.class, id);
  }

}