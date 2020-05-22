class A {
    private boolean isInitialized = false;
    private final B b             = new B(this);
    public A() {
        initialize();
    }
    private void initialize() {
        isInitialized = true;
    }
    public boolean isInitialize() {
        return isInitialized;
    }
    public B getB() {
        return b;
    }
}

class B {
    private boolean isInitialized = false;
    final private A a;
    public B(final A a) {
        this.a = a;
        initialize();
        System.out.println("inB:          a.isInitialize()=" + a.isInitialize());
    }
    private void initialize() {
        isInitialized = true;
    }
    public boolean isInitialize() {
        return isInitialized;
    }
}

public static void main(final String[] args) {
    final A a = new A();
    System.out.println("inMain:       a.isInitialize()=" + a.isInitialize());
    System.out.println("inMain:a.getB().isInitialize()=" + a.getB().isInitialize());
}