class Something {
    void addSomething(Something sth) {
    }
}

class InnerClass {
    Something getSomething() {
        return new Something();
    }
}

class TestClass {

    private final InnerClass inner;

    TestClass(InnerClass inner) {
        this.inner = inner;
    }

    public void methodToTest() {
        inner.getSomething().addSomething(new Something());
    }
}