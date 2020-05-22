class MyEnum<E extends MyEnum<E>> {
    private Thing<E> util1() { return someObject }
    private void util2(E e) {}
    public int method(E o) { 
        Thing<E> thingy = o.util1(); 
        // You can call the util1 method on o and get a type safe return element.
        E o1 = // I don't care how you get a parametrized E object.
        o.util2(o1);
        // You can call the util2 method with a typesafe parameter.
    }
}