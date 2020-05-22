@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinTable(name = "company_employee", joinColumns = @JoinColumn(name = "company_id", referencedColumnName="id") 
                                        , inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName="id"))
    @ManyToMany(fetch = FetchType.LAZY)
    List<Employee> employees = new ArrayList<>();

    String name;
}

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
    List<Company> companies = new ArrayList<>();

    String name;
}

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int schedule_id;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "schedule")
    List<Vacation> vacations;

}

@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vacation_id;

    @ManyToOne
    @JoinColumn(name = "schedule_id" ) 
    Schedule schedule;

    @OneToMany(mappedBy = "vacation")
    List<Day> days;
}