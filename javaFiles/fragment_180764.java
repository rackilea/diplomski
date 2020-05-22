public class ChildA extends Parent<ChildA> {

  public ChildA childAMethod() {
    System.out.println(this.getClass().getCanonicalName());
    return this;
  }
}

public class ChildB extends Parent<ChildB> {

  public ChildB childBMethod() {
    return this;
  }
}