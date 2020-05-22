@Entity
public class Entity1 {
  @Id
  @SequenceGenerator(name = "entity1Seq", sequenceName="ENTITY1_SEQ", allocationSize=1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity1Seq")
  @Column(name = "ID", nullable = false)
  private Long id;

  ...
  ...

}

@Entity
public class Entity2 {
  @Id
  @SequenceGenerator(name = "entity2Seq", sequenceName="ENTITY2_SEQ", allocationSize=10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity2Seq")
  @Column(name = "ID", nullable = false)
  private Long id;

  ...
  ...

}