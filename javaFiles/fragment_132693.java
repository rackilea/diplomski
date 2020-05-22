@Entity
  @Table(name="Employees")
  public class Employee {

  @ManyToOne
  @JoinColumn(name = "your_fk_column")
  private City city;
  }