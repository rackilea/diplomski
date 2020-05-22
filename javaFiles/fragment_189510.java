public class EmployeeBacking {

    private List<Employee> list;

    public EmployeeBacking() {
        list = employeeService.list();
    }

    // ...
}