class SuperClass { public String getName() { ... } public String getInfo() { ... }

@Entity
class ChildClass extends SuperClass {
  @Id
  private long id;

  public Long getId() { return id; }

  @Access(AccessType.PROPERTY)
  @Column(name = "name")
  public String getName() { return super.getName(); }

  @Access(AccessType.PROPERTY)
  @Column(name = "info")
  public String getInfo() { return super.getInfo(); }
}