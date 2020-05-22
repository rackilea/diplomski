// p/a/A.java
package p.a;
import p.b.B;
public class A {
    public static final A DEFAULT_A = new B();
}

// p/b/B.java
package p.b;
import p.a.A;
public class B extends A {
}