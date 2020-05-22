public interface A {
    public void a();
}

public interface B {
    public void b();
}

public class ABComposition implements A, B {    
    private A a;
    private B b;

    public ABComposition(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void a() {
        a.a();      
    }

    @Override
    public void b() {
        b.b();
    }
}