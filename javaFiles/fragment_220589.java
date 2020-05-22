public class A {
    public void f() { System.out.println("A.f");x = x + 4; g();System.out.println(this); }
    public void g() { System.out.println("A.g");x = x + 10;}
    public int x = 5;
    }


public class B extends A {
    @Override public void f() { System.out.println("B.f");x = x + 3; super.f(); }
    @Override public void g() { System.out.println("B.g");x = x + 15; }
}