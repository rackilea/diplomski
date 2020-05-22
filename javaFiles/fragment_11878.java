public class Foo {
   public static void main(String[] args) {
      A a = new A();
      B b = new B(a); // pass A reference into B

      b.someMethodInB();
   }
}

class A {
   // the method that we're interested in!
   public void method1() {
      System.out.println("method1 in A");
   }
}

class B {
   private A a; //give B a field to hold A's reference

   // Allow B's constructor to accept the A reference
   public B(A a) {
      this.a = a;  // and assign it to a field
   }

   public void someMethodInB() {
      a.method1();   // now B can call A's method
   }
}