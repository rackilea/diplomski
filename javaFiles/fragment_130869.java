class X {
    int i;

    void foo() {
        for (i = 0; i < 10; ++i) {
            bar();
        }
    }

    void bar() {
        for (i = 0; i < 20; ++i) {
            System.out.println("foobar");
        }
    }
}