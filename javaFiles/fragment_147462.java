abstract class Foo {

  private final Set<CanDos> candos;

  protected Foo(Set<CanDos> candos) 
  {
     this.candos = new EnumSet<CanDos>(candos);
  }

  public boolean can(CanDos item) {
    return candos.contains(item);
  }
}