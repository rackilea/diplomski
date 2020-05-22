//Spy UnderTest and call methodToTest()
    UnderTest mUnderTest = new UnderTest();
    UnderTest spyUnderTest = Spy(mUnderTest);
    spyUnderTest.methodToTest();

    //Verify methodToCall1() and methodToCall2() were invoked
    verify(spyUnderTest).methodToCall1();
    verify(spyUnderTest).methodToCall2();