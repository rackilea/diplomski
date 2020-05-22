public class Employee {
    public String name;  public int sal;        
    public Employee() {name = ""; sal = 0;}
    public Employee(String name, int sal) {
        this.name = name; this.sal = sal;
    }
    @Override public String toString() {return "(" + name + "," + sal + ")";}
}

public class Team {
    private Map<String, ArrayList<Employee>> employees = 
             new HashMap<String, ArrayList<Employee>>();
    private ArrayList<Employee> order = new ArrayList<Employee>();

    public void addEmployee(Employee e) {
        ArrayList<Employee> list = employees.get(e.name);     
        if (list == null) {
            list = new ArrayList<Employee>();
            employees.put(e.name, list); 
        } 
        list.add(e);
        order.add(e);
    }         
    public int getNumEmployees() {return order.size();}
    public Employee getEmployee(int n) {return order.get(n - 1);}       
    public int getNumEmployees(String name) {
        ArrayList<Employee> list = employees.get(name);
        return list == null ? 0 : list.size();
    }
    public Employee getEmployee(String name, int n) {
        ArrayList<Employee> list = employees.get(name);
        return list == null ? null : list.get(n - 1);
    }
}

// Test:
Team team = new Team();
team.addEmployee(new Employee("Bob", 11));
team.addEmployee(new Employee("Bob", 12));
team.addEmployee(new Employee("Eve", 13));
team.addEmployee(new Employee("Eve", 14));

System.out.println("Num all: " + team.getNumEmployees()); 
System.out.println("3rd: " + team.getEmployee(3));
System.out.println("Num Bobs: " + team.getNumEmployees("Bob")); 
System.out.println("2nd Bob: " + team.getEmployee("Bob", 2));