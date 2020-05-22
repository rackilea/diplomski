@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> listEmployeess() {
       Session session = sessionFactory.getCurrentSession();
       Transaction tx = session.beginTransaction();
       Criteria criteria = session.createCriteria(Employee.class);
       List<Employee> list = (List<Employee>)criteria.list();
       tx.commit();
       return list;
    }

    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
    }

    public void deleteEmployee(Employee employee) {
      Session session = sessionFactory.getCurrentSession();
      Transaction tx = session.beginTransaction();
      Query query = session.createQuery("Delete Employee where empid=:empid");
      query.setParameter("empid", employee.getEmpId());
      int result = query.executeUpdate();
      tx.commit();
   }
}