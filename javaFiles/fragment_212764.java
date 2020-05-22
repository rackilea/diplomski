class SuperClass { public String getName() { ... } public String getInfo() { ... }

@MappedSuperClass
class NamedModel extends SuperClass {
  @Access(AccessType.PROPERTY)
  @Column(name = "name")
  public String getName() { return super.getName(); }

  @Access(AccessType.PROPERTY)
  @Column(name = "info")
  public String getInfo() { return super.getInfo(); }
}

@Entity
class ChildClass extends NamedModel {
  @Id
  private long id;
}