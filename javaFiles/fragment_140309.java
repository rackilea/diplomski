import org.springframework.stereotype.Component;

@Component
public class Department {
  private String name;
  private String id;
  private int employeeCount;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public int getEmployeeCount() {
    return employeeCount;
  }
  public void setEmployeeCount(int employeeCount) {
    this.employeeCount = employeeCount;
  }
  @Override
  public String toString() {
    return "Department [name=" + name + ", id=" + id + ", employeeCount=" + 
           employeeCount + "]";
  }
  public Department() { }
  public Department(String name) { 
    this.name = name;
  }
  public Department(String name, String id) {
    this.name=name;
    this.id=id;
  }
  public Department(String name, String id, int employeeCount) {
    this.name=name;
    this.id=id;
    this.employeeCount = employeeCount;
  }
}