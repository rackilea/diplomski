@Entity
@Inheritance(strategy=SINGLE_TABLE)
@NamedQuery(name="queryName", query="SELECT p FROM Parent p ORDER BY p.createdDate DESC, DTYPE(p) ASC")
public abstract class Parent {

  @Temporal(TIMESTAMP)
  private Calendar createdDate;
}