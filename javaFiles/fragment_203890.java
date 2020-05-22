public class Employee {

   static List<Employee> employeeList = new ArrayList<Employee>();
    private int id;
    private String firstName;
    private int age;
    private double salary;
    private String department;

    public Employee(int id, String firstName, int age, double salary, 
    String department) {
    this.id = id;
    this.firstName = firstName;
    this.age = age;
    this.salary = salary;
    this.department = department;
    }

    public static void main(String[] argv) {
    Employee employee1 = new Employee(1, "Pavan", 45, 20000.00, 
    "Uppal");
    Employee employee2 = new Employee(2, "Mahesh", 35, 10000.00, 
    "Uppal");       

    employeeList.add(employee1);
    employeeList.add(employee2);

   }

 }