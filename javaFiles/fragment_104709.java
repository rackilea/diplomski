class B {
    private A a;

    public B(A a) {
        this.a = a;
    }

    int m() {
        return a.m();
    }
}