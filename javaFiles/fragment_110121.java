@Entity
@Table(name="ParentOne", schema="S1")
public class ParentOne {
  @Id
  @Column(name="ParentOneID", unique=true, nullable=false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="parentOne")
  private List<Child> children;

  public void addChild(final Child child) {
    if (children == null) {
      children = new ArrayList<>();
    }

    children.add(child);

    child.setParentOne(this);
  }
}