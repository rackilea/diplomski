class B implements A<Foo> {
    @Override
    public <T extends Foo> void X(T type1) { /* impl */ }
}

class C implements A<Bar> {
    @Override
    public <T extends Bar> void X(T type2) { /* impl */ }
}