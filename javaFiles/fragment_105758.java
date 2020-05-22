@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "SUPERVISOR", referencedColumnName = "id")
  private Employee supervisor;

  @OneToMany(mappedBy="supervisor") 
  private List<Employee> responsibilities;
  ...
}