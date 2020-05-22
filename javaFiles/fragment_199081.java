@SecondaryTable(name="EMP_ATTRIBUTES")
@Entity
public class Employee {
  @Id private int id;
  @Column(table="EMP_ATTRIBUTES")
  private String attribute;
}