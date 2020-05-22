import java.util.ArrayList;

public class Employee {
    public String FullName;
    public float wage;
    public int ID;

    Employee(String name, float wage, int ID){
        this.FullName = name;
        this.wage = wage;
        this.ID = ID;
    }

    public static void main(String[] args) {
        ArrayList<Employee> employ = new ArrayList<Employee>();
        Employee e = new Employee("Tony", 1245, 2222);
        employ.add(e);
    }
}