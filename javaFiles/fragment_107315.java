@test
public voide testCase() {
    IMocksControl ctrl = createStrictControl();
    OrderTester mockedOrderTester = ctrl.createMock(OrderTester.class);
    MyObject mockedMyObject = ctrl.createMock(MyObject.class);
    mockedOrderTester.method2()
    expectLastCall();
    mockedMyObject .method1()
    expectLastCall();
    mockedOrderTester.method3()
    expectLastCall();
    ctrl.replay();
    ClassUnderTestExt testClass = new ClassUnderTestExt();
    testClass.ot = mockedOrderTester;
    testClass.mo = mockedMyObject;
    testClass.method1();
    ctrl.verify();
}


class ClassUnderTestExt extends ClassUnderTest<String> {
    public OrderTester ot;
    public MyObject mo;

    @Override
    public void writeOutput(String data) {
    }

    @Override
    public void method2() {
        super.method2();
        ot.method2();
    }

    @Override
    public void method3() {
        super.method3();
        ot.method3();
    }
}

class OrderTester {
    public void method2() {
    }

    public void method3() {
    }
}