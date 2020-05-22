@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinTable(name = "company_employee", joinColumns = @JoinColumn(name = "company_id") , inverseJoinColumns = @JoinColumn(name = "employee_id") )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> employees;
}


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinTable(name = "company_employee", joinColumns = @JoinColumn(name = "employee_id") , inverseJoinColumns = @JoinColumn(name = "company_id") )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Company> companies;
}