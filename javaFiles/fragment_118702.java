public class MyEntity {
  @Column(name = "NAME")
  private String name;
  @Column(name = "NAME", insertable = false, updatable = false)
  private String name2;
}