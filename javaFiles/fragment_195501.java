@Entity
public class Item {
  @Id private Integer id;
  private String name;
  @ManyToOne
  private Operation  operationStart;
  @ManyToOne
  private Operation  operationEnd;

  //set/getters/hashcode/etc. omitted
}

@Entity
public class Operation {
  @Id private Integer id;
  private String name;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy="operationStart")
  private List<Item> items = new ArrayList<Item>();

  //set/getters/hashcode/etc. omitted
}