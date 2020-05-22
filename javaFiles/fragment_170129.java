public class A {
    public static class B {
        int k;
        public B(int a) { k=a; }
    }
    B sth;
    public A(B b) { sth = b; }
}

new A.B(4);