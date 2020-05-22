@Entity
@Table(name="T_EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="NAME")
    private String name;

    @OneToMany(mappedBy="employee")
    Collection<EmployeeDocument> documents = new ArrayList<>();
}


@Entity
@Table(name="T_DOCUMENT")
public class EmployeeDocument {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private Employee employee;
}