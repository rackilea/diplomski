public class Main {
    public static void main(String[] args) {
        P p = new P(3);
        P p1 = new P(4);
        A a = new A(p);
        A a1 = new A(p1);
        System.out.println("a:  " + a.p.k);
        System.out.println("a1: " + a1.p.k);
        a1 = a;
        System.out.println("a:  " + a.p.k);
        System.out.println("a1: " + a1.p.k);
    }
}

class A {
    public P p;

    public A(P p) {
        this.p = p;
    }
}

class P {
    public int k;

    public P(int k) {
        this.k = k;
    }
}