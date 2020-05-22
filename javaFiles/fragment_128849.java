import java.util.*;

public class Student {

    private String name;
    private String address;
    private double GPA;
    static LinkedList<Student> stu = new LinkedList<Student>();
    static Scanner scanner = new Scanner(System.in);


    public Student(String name, String address, double GPA) {
        this.name = name;           //this.name instead of Student.name
        this.address = address;     //this.address instead of Student.address
        this.GPA = GPA;             //this.GPA instead of Student.GPA
    }

    public String getName() {
        return this.name;           //similarly
    }

    public String getAddr() {
        return this.address;        //similarly
    }

    public double getGPA() {
        return this.GPA;            //similarly
    }

    public static void main(String [] args) {
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter the student's name: ");

            //notice here. "name" can be changed to anything, "sname" for example
            //this variable is just to store the input, it's not related to the name
            //attribute in the class
            String name = scanner.next();
            System.out.println("Enter the student's address: ");

            //same goes for address and GPA
            String address = scanner.next();
            System.out.println("Enter the student's GPA: ");
            double GPA = scanner.nextDouble();

            //use the input taken above to create a new student by calling the constructor
            stu.addLast(new Student(name, address, GPA));
        }
        System.out.println(stu);
    }

    @Override
    public String toString() {
        String str = "Name: " + getName() + "\nAddress: " + getAddr() + "\nGPA: " + getGPA()+ "\n\n";
        return str;
    }
}