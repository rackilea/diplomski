@Entity
@Table(name = "TABLE_ONE")
public class TableOne {

  @Id
  @Column(name="id")
  private int id;
  @Column(name="name")
  private String name
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "tableOne")
  private List<TableTwo> tableTwoList;
  //getters, setters, constructors        
}

@Entity
@Table(name = "TABLE_TWO")
public class TableTwo {

  @EmbeddedId
  private TableTwoCompositeId tableTwoCompositeId;
  @MapsId("provider") // maps provider attribute of embedded id
  @ManyToOne
  @JoinColumn(name = "TABLE_ONE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
  private TableOne tableOne;
  //getters, setters, constructors        
}


@Embeddable
public class TableTwoCompositeId {
    @Column(name = "TABLE_ONE_ID")
    public int provider;
    @Column(name = "NAME")
    public String name;
    @Column(name = "EMAIL")
    public String email;
    //getters, setters, constructors
}