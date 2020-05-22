class Test {
    void foo(int... i) {}
    void foo(Object... o) {}

    void test() {
       foo(1,2,3);
    }
}