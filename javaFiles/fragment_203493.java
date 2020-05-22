@Entity
@Table(name = "template")
public class Template {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private long id = 0;

  @Column(name="name")
  private String name = "";

  // Left side of map maps to name field of the item on the right side of the map
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="template")
  @MapKey(name = "name")
  private Map items = new HashMap();
  ...
}