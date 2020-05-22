class Parent {
    public int method() {
        return 0;
    }
}

class Child extends Parent {
    public short method() { // compilation error
        return 0;
    }
}