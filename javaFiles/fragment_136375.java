public class Main {

  class A {}
  class B extends A {}
  class C extends B {}

  public static void main(String[] args) {
    new Main().experiment();
  }

  private void experiment() {
    Object o = new B();

    boolean a = (o instanceof B) && (!(o instanceof A));
    boolean b = (o instanceof B) && (!(o instanceof C));
    boolean c = !((o instanceof A) || (o instanceof B));
    boolean d = (o instanceof B);
    boolean e = (o instanceof B) && !((o instanceof A) || (o instanceof C));

    System.out.println("a = "+a);
    System.out.println("b = "+b);
    System.out.println("c = "+c);
    System.out.println("d = "+d);
    System.out.println("e = "+e);
  }

}