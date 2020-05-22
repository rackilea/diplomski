abstract class A {
    abstract void m();
    void n() {}
}
class C extends A {
    // C.m() both overrides and implements A.m()
    @Override
    void m() {}
    // C.n() overrides A.n(), but does not implement it
    @Override
    void n() {}
}