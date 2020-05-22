CustomObject mockCustomObject = mock(CustomObject.class);
when(mockCustomObject.testMethod()).thenReturn(...);

MainClass sut = new MainClass();
sut.setCustomObject(mockCustomObject);

sut.makeCall();

verify(mockCustomObject).testMethod();