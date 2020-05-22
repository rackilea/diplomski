@Entity
@Table(name="EMPLOYEE")
public class Employee{

    ...

    @OneToOne(fetch =FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private Address address;