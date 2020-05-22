@Entity
public class Employee {
    @Embedded
    private EmployeeDetails details;
}

@Embeddable
public class EmployeeDetails {
}