@Entity
@Table(name = "company")
public class Company {
...
@OneToMany// or @ManyToMany
@JoinTable(name = "table_name",
    joinColumns = @JoinColumn(name="employeeId", referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name="companyId",  referencedColumnName="id"))
private List<Employee> employeeList;