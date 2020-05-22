class A extends AbstractFancy {
    Fancy create() {
        return new A();
    }
}
class B extends AbstractFancy {
    Fancy create() {
        return new B();
    }
}