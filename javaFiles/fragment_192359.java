@MappedSuperclass
public abstract class AbstractEmployee {
    @Id
    @Column(name = "EMPLOYEENUMBER")
    private String employeeNumber;

    @Column(name = "EMPLOYEENAME")
    private String employeeName;

    @Column(name = "DEPARTMENT")
    private String dept;

    // Constructor, getters, setters
}

@Entity
@Table(name = "V_EMPLOYEES")
public class ReadOnlyEmployee extends AbstractEmployee {
}

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends AbstractEmployee {
    // Extra mappings here
}