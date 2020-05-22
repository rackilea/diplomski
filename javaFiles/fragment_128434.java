@Override
public List<Employee> getEmployees() {

Session currentSession=sessionFactory.getCurrentSession();
List<Employee> employeeList=
        currentSession.createQuery("from employees order by 
last_name").getResultList();
return employeeList;
}