public class Record
  {
    private Set<Employee> employeeSet = new HashSet<Employee>();

    public Record()
    {
        newEmployee("1");
        newEmployee("2");
        newEmployee("3");
    }

    public void newEmployee(String employNumber)
    {
        Employee newEmp = new Employee(employNumber);
        employeeSet.add(newEmp);
    }
 }