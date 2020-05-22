public class EmployeeStore {
    private Map<String, Employee> employees;

    public EmployeeStore() {
        employees = new HashMap<String, Employee>();
    }

    public void add(Employee e) {
        employees.add(e.getName(), e);
    }

    public Employee searchByName(String name) {
        return employees.get(name);
    }

    // etc.
}