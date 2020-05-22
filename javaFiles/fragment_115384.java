Sample objectToTest = new Sample();

Object1 mockedObject1 = mock(Object1.class);
objectToTest.process(mockedObject1);

Object2 obj2 = new Object2(expectedValue1, expectedValue1);
verify(mockedObject1).process(obj2);