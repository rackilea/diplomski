class Base {
    static void foo () {}
}

class Derived extends Base {
    void foo () {} // say this compiled
}

Base b = new Derived()
b.foo(); // should the static or the virtual method be called?