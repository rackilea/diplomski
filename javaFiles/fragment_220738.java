import java.util.HashMap;
import java.util.Map;

public class Employee
{
  private final String name;
  private final int Id;
  private static Map<String, Employee> employeesByName = new HashMap<String, Employee>();
  private static Map<Integer, Employee> employeesById = new HashMap<Integer, Employee>();

  public Employee(String empName, int empId)
  {
    name = empName;
    Id = empId;
    employeesByName.put(name, this);
    employeesById.put(Id, this);
  }

  public static Employee getEmployeeByName(String name)
  {
    return employeesByName.get(name);
  }

  public static Employee getEmployeeById(int Id)
  {
    return employeesById.get(Id);
  }
}