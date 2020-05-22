class B {
    private A a;
    void setA(A a) {
        this.a = a;
    }
    void run() {
        a.test("something");
    }
}