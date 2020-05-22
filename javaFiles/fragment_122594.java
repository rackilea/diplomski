public class Parent {
  protected string name;

  public Parent() {
    name = "Parent's value";
  }

  public void setName(string newValue) {
    name = newValue;
  }

  public void display() {
    System.out.println(name);
  }
}

public class Child1 extends Parent {
  public Child1() {
    name = "Child1's value";
  }
}

public class Child2 extends Parent {
  public Child2() {
    name = "Child2's value";
  }
}

public static void main() {
  new Parent().display();
  new Child1().display();
  Child2 c2 = new Child2();
  c2.display();
  c2.setName("New name!");
  c2.display();
}