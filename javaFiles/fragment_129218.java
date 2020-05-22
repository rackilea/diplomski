class Foo<E>
{
    void foo(Object [] oa) {
        oa[0] = new Object();
    }

    public E get() {
        E[] ea = (E[]) new Object[5];
        foo(ea);
        return ea[0];  // returns the wrong type
    }
}

class Other
{
    public void callMe() {
        Foo<String> f = new Foo<>();
        String s = f.get();   // ClassCastException on *this* line
    }
}