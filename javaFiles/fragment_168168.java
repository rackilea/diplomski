@Entity
@Table(name = "EMPLOYEE")
@Access(value=AccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_salary")
    private double salary;

     @OneToOne(mappedBy = "employee" , cascade = CascadeType.ALL)   
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getName() {
        System.out.println("Employee getName called");
        return name;
    }

    public void setName(String name) {
        System.out.println("Employee setName called");
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id= " + id + ", Name= " + name + ", Salary= " + salary
                + ", {Address= " + address + "}";
    }