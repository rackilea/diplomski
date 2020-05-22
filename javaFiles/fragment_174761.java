static class Parent {

    private int i;

    void m(Child child) {
        i = child.i; //compile error
    }
}

static class Child extends Parent { }