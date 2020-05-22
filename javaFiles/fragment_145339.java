//interactions
mock.doSomething();
mock.doSomethingUnexpected();

//verification
verify(mock).doSomething();

//following will fail because 'doSomethingUnexpected()' is unexpected
verifyNoMoreInteractions(mock);