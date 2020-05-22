public interface Employee {
    String getFirstName();
    String getLastName();
}
public class EmployeeImpl implements Employee {
    private String firstName;
    private String lastName;

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public void setFirstName(String name) {firstName = name;}
    public void setLastName(String name) {lastName = name;}
}