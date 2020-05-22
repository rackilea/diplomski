class A {
    void m(int i) {}
}

class B extends A {
    void m(double d) {}
}

A a = new B();

double d = 0d;
a.m(d); // won't compile
        // will say something like
        // 'double can not be converted to int'