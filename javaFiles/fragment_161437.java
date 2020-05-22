@Stateless
public class DepartmentManagerBean implements DepartmentManager {

    @PersistenceUnit(unitName="EmployeeService")
    EntityManager txScopedEM;

    @PersistenceUnit(unitName="EmployeeService")
    EntityManagerFactory emf;

    @TranactionAttribute(REQUIRED)
    public void modifyDepartment(int deptId) {
        Department dept = txScopedEM.find(Department.class, deptId);
        dept.setName("New Dept Name");
        List<Employee> empList = getEmpList();
        for(Employee emp : empList) {
            txScopedEM.merge(emp);
            dept.addEmployee(emp);
        }
        dept.setEmployeeCount(empList.size()); 
    }

    @TranactionAttribute(NOT_SUPPORTED)
    public void getEmpList() {
        EntityManager appManagedEM = emf.createEntityManager();
        TypedQuery<Employee> empQuery = appManagedEM.createQuery("...", Employee.class);
        List<Employee> empList = empQuery.getResultList();
        // ...
        appManagedEM.clear();
        return empList;
    }
}