class Manipulator {
    private A a;
    Manipulator(A a) {
        this.a = a;
    }
    void manipulate() {
        int value = a.getValue();
        a.setValue(value + 42);
    }
}