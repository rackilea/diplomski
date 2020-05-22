public class Employee
{

    public string ID;
    public Manager Manager;

    public Manager promote() { return new Manager(this); }

    public Employee() { }

}

public class Manager : Employee
{

    public List<Employee> Employees;

    public Manager() { }
    public Manager(Employee employee) {...}

}

public class EmployeeModel
{

    private List<Employee> employees;
    public List<Employee> Employees { get { return this.employees; } }

    public void addEmployee(...) {...}
    public void removeEmployee(...) {...}
    public void promoteEmployee(...) {...}

}