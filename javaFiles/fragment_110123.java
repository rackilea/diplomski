@Entity
@Table(name="ChildTable", schema="S2")
public class Child {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ChildTableID", unique=true, nullable=false)
  private Integer id;

  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name="ParentOneID", nullable=false)
  private ParentOne parentOne;

  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name="ParentTwoID", nullable=false)
  private ParentTwo parentTwo;

  void setParentOne(final ParentOne parentOne) {
    this.parentOne = parentOne;
  }

  void setParentTwo(final ParentTwo parentTwo) {
    this.parentTwo = parentTwo;
  }
}