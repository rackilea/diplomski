public class Employee {
    public int id;
    public String fName;
    public String mName;
    public String lName;
    public Employee(String line) {
        String[] split = line.split(",");
        id = Integer.parseInt(split[0]);
        fName = split[1];
        mName = split[2];
        lName = split[3];
    }
}