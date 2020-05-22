PowerMockitoTest testclass = PowerMockito.spy(new PowerMockitoTest());
    try {
        PowerMockito.doNothing().when(testclass,  PowerMockito.method(PowerMockitoTest.class, "TestPrivateMethod")).withNoArguments();
    } catch (Exception e) {
        e.printStackTrace();
    }
    testclass.TestPublicMethod();