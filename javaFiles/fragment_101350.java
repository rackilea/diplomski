public class Employee implements Comparable<Employee> {

    public int compareTo(Employee o) {
        //this is an example. Obviously, you can put whatever you want here 
        return (int)(this.salary-o.salary);
    }
}