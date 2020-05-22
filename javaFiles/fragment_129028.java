public static class Base {
    public void callBoth() {
        foo();
        bar();
    }

    private void foo() {
        System.out.println("Base.foo");
    }

    protected void bar() {
        System.out.println("Base.bar");
    }
}

public static class Sub extends Base {
    public void foo() {
        System.out.println("Sub.foo");
    }

    public void bar() {
        System.out.println("Sub.bar");
    }
}