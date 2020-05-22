class A {
    B b;
    ....
    // Perhaps you can do somthinkg like this to maintain consitsncy
    void setB(B b) {
        this.b = b;
        b.a = a;
}
class B {
    A a;
    ....
}