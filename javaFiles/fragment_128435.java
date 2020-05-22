@Override
public List<Employee> getEmployees() {

Session currentSession=sessionFactory.getCurrentSession();
List<Employee> employeeList=
        currentSession.createQuery("from Employee order by 
lastName").getResultList();
return employeeList;
}