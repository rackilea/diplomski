class Test {
    public void foo(int arg) {}
    public static void bar(int arg) {}
    public void baz() {
        foo(1);
        bar(2);
    }
}