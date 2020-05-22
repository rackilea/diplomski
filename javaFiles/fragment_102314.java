class B {
    private A a;
    B(A a) {
        this.a = a;
    }
    void run() {
        a.test("something");
    }
}