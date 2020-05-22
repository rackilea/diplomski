@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @Id @GeneratedValue
    private long id;

    ...
}

@Entity
public class CompanyPayment extends Payment {

    @Column(unique = true)  
    public Date period;

    ...
}

@Entity
@Table(uniqueConstraints =
    @UniqueConstraint(columnNames = { "period", "department_id" })
)
public class DepartmentPayment extends Payment {

    public Date period;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    ...
}