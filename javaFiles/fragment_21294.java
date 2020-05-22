@Stateless
public class EmployeeServiceBean implements EmployeeService {
    @PersistenceContext(unitName="MyPu")
    private EntityManager em;

    public Employee createEmployee(int id, String name, long salary) {
        Employee emp = new Employee(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }
    ...    
}