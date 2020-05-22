/*Employee class as root node*/
@XmlRootElement
public class Employee {

private String name;
private int age;
private int id;
private double salary;

public Employee() {
    super();
    // TODO Auto-generated constructor stub
}

public Employee(String name, int age, int id, double salary) {
    super();
    this.name = name;
    this.age = age;
    this.id = id;
    this.salary = salary;
}

/*add as attribute into root node*/
@XmlAttribute
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

/*add as element*/
@XmlElement
public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

@XmlAttribute
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

@XmlElement
public double getSalary() {
    return salary;
}

public void setSalary(double salary) {
    this.salary = salary;
}

}