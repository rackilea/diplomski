public class Main extends ReusaxCorp {

public Main(String ID, String name, double grosssalary) {
    super(ID, name, grosssalary);
}

public static void main(String[] args){

    ArrayList<Employee> employees = new ArrayList<Employee>();

    Employee e = createEmployee();
    employees.add(e);
}

    public static Employee createEmployee(){
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter the ID of the employee: ");
        String identity = input.nextLine();
        System.out.print("Please enter the name of the employee: ");
        String empname = input.nextLine();
        System.out.print("Please enter the gross salary of the employee: ");
        double empsalary = input.nextDouble();

        Employee Employee = new Employee(identity, empname, empsalary);
        return Employee;
    }
}