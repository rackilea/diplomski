@Named
public class EmployeesDAO implements IEmployeesDAO {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Employees> getEmployees() {

             List query = sessionFactory.getCurrentSession().getNamedQuery("getEmp").list();

        return query;
    }
}