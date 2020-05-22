@Entity
class AnotherDependentEntity implements Serializable {

  @Id    
  @ManyToOne( fetch = FetchType.LAZY, optional = false )
  @JoinColumn( name = "mainEntityId", insertable = false, updatable = false, nullable = false )
  private MainEntity mainEntity;

  @Id
  @Column ( name = "type", insertable = false, updatable = false, nullable = false )
  private SomeEnum type;
}