public static void main(String[] args) {
    new B().foo();
}

static class A {
    public void foo() {
        System.out.println("In A");
    }
}

static class B extends A {
    public void foo() {
        System.out.println("In B");
        super.foo();
    }
}