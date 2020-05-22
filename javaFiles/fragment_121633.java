class A {

    private B b;

    public static A newInstance(B b) {
        A a = new A();
        a.b = b;
        return a;
    }

}

A a = A.newInstance(new B());