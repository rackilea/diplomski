interface I {
    public void method();
}

class A implements I {
    public final void method() {
        System.out.println("Hello World!");
    }
}

class B extends A { }