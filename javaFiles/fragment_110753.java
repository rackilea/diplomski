class A {

  String name;

  public A() {
    this.name = "Fred";
  }

}

class B extends A {

  public boolean equals(Object o) {
    A a = (A)o;
    return a != null && a.name.equals(this.name);
  }
}

public class Test {

  public static void main(String[] args) {

    A a = new A();
    B b = new B();

    System.out.println(a.equals(b) == b.equals(a));
  }
}