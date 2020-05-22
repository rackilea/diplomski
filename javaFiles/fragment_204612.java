Foo mock = mock(Foo.class, CALLS_REAL_METHODS);

 // this calls the real implementation of Foo.getSomething()
 value = mock.getSomething();

 when(mock.getSomething()).thenReturn(fakeValue);

 // now fakeValue is returned
 value = mock.getSomething();