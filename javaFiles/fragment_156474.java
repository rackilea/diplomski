class A {
    public void foo() {
        System.out.println("A foo");
    }
}

class B extends A {
    public void foo() {
        System.out.println("B foo");
    }

    public void bar() {
        System.out.println("B bar");
    }
}