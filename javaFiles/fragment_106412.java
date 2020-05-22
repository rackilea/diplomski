// Initialization - should probably be in the @Before method:
A a = Mockito.spy(new A());
Mockito.doThrow(new SomeException("yay!")).when(a).m2();

// Actual test:
SomeResult actualResult = a.m1();
assertEquals(someExpectedResult, actualResult); // or some other assertion