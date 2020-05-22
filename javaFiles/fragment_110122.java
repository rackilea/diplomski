@Entity
@Table(name="ParentTwo", schema="S2")
public class ParentTwo {
  @Id
  @Column(name="ParentTwoID", unique=true, nullable=false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="parentTwo")
  private List<Child> children;

  public void addChild(final Child child) {
    if (children == null) {
      children = new ArrayList<>();
    }

    children.add(child);

    child.setParentTwo(this);
  }
}