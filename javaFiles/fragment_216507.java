interface A<T> { 
    void X(T t);
}
class B implements A<Foo> {
    @Override
    public void X(Foo type1) { /* impl */ }
}

class C implements A<Bar> {
    @Override
    public void X(Bar type2) { /* impl */ }
}