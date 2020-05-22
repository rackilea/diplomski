class Base {
    Base {
        m(); // <- problem here
    }

    abstract void m();    
}

class Derived extends Base {
    Derived() {
        this.a = new A();
    }

    void m() {
        a.a();
    }

    private final A a;
}