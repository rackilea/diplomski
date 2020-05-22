class A {
    protected void m() {}
}

class B extends A {
    @Override
    public void m() {}
}

// in another package...
B b = new B();
b.m(); // call m because it is public in B
A a = b;
a.m(); // won't compile because it is protected in A