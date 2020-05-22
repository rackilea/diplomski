public class Superclass {
  protected int id;
  protected void foo() {
    System.out.println("Foo in superclass");
  }

  public Superclass() {
    foo();
  }
}

public class Subclass extends Superclass {
  public Subclass(int id) {
    super();
    this.id = id;
  }

  @Override
  protected void foo() {
    System.out.println("Id is " + id);
  }
}