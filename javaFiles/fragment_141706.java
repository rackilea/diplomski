@Entity
public class Parent implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToMany(mappedBy ="parent")
  @JoinColumn(name = "parent_id")
  @MapKeyColumn(name = "ranking")
  private Map<String, Relationship> ranking;
}