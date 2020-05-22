class TestB extends TestA {
    Object myCopyOfFoo;

    // I assume you actually wanted this to take a parameter called foo?
    // I've left it as per the question...
    TestB() {
        this(new Object());
    }

    private TestB(Object copy) {
        super(copy);
        myCopyOfFoo = copy;
    }
}