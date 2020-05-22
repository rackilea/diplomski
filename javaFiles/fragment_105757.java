@Entity
@Table(name = "EMPLOYEE")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "SUPERVISOR", referencedColumnName = "id")
  private Employee supervisor;

  @OneToOne(mappedBy="supervisor") 
  private Employee responsibility;
  ...
}