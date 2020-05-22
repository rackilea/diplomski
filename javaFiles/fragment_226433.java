@Repository
@Transactional
public class EmployeeDaoJpa implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    // Method implementations using the EntityManager

}