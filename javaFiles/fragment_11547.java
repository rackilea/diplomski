public class A
{
    private B b;
    private C c;

    public A(B b, C c)
    {
        this.b = b;
        this.c = c;
    }
}

// When creating your object graph, in the "composition root":
B b = new B();
C c = new C(b);
A a = new A(b, c);