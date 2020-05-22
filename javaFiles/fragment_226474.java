@Entity
public class Employee {
  @Id
  @Column(name="Emp_ID")
  private long id;

  @OneToMany
  @JoinColumn(name="Emp_ID", referencedColumnName="City_ID")
  private List<City> cities;
  // ... rest of the class: constructor, getters, setters
}