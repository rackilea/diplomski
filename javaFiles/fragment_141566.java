@Entity
public class Person {
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private Integer age;
  // any person can have this, not just children imo :)
  private String favoriteShow;

  @OneToMany(mappedBy = "parent")
  private Set<Person> children;

  @ManyToOne
  private Person parent;

  @Transient
  public boolean isChild() {
    return children == null || children.isEmpty();
  }

  @Transient
  public boolean isParent() {
    return !isChild();
  }

  @Transient
  public boolean isGrandParent() {
    return isParent() 
         && children.stream().filter( Person::isParent ).count() > 0;
  }
}