public class HelloWorld {

  public static void main(String[] args) {
     A a = new A("A String");
     B b = new B("B String");
     System.out.println(a.toString()); // A String some random text
     System.out.println(b.toString()); // B String some random text
   }
}

class A {
  protected String name;

  A(String name) {
    this.name = name;
  }

  public String toString() {
    return name + " some random text";
  }
}

class B extends A {

  B(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return (super.toString());
  }

}