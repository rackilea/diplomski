public class Employee {
    public int id;
    public String fName;
    public String mName;

public Employee(int id, String fName, String mName) {
    this.id = id;
    this.fName = fName;
    this.mName = mName;
}




@Override
public String toString() {
    String output = "Hello, I am employee " + id + ", my first name is " + fName + " and my middle name is " + mName;
    return output;
}


public static void main(String[] args) {
    Employee e= new Employee(1, "foo" ,"bar");
    System.out.println(e.toString());
}
}