@Entity @Table(name = "employees") public class Employee {

    @Id
    @Column(name = "emp_no")
    private long empNo;

    @OneToMany(mappedBy="employee")
    private List<Title> titles = new ArrayList<>();

    ... }