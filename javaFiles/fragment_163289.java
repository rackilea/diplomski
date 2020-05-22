public interface IEmployeeRepository
{
    List<Employee> List();
    void Add(int employeeID);
    void Delete(int employeeID);
}