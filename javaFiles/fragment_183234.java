public class A {

    public int i;

    public A(int i) {
        this.i = i;
    }

    public class B {
        void foo() {
            System.out.println(A.this.i);
        }
    }

    public class C extends B {
        C(A a) {
            a.super();
        }
        void bar() {
            System.out.println(A.this.i);
        }
    }

    public static void main(String[] args) {
        A a1 = new A(1);
        A a2 = new A(2);
        C c = a1.new C(a2);
        c.foo();
        c.bar();
    }
}