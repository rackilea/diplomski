class EmployeeFactory{
  public Employee getEmployee(){...}
}

class Check{
  private EmployeeFactory factory;
  public Check(EmployeeFactory factory){ this.factory = factory;

  public String myCheck()
  {
    List<Employee> employee = factory.getEmployee();
}