@Entity
@Table(name = "mypack.A")
public class A implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "REF_ID")
  private A refA;
  @Column(name = "NAME")
  private String name;
  // getters and setters
}