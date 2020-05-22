//First you create a mock with an annotation
@Mock
private Client clientMock;

// ...

// Then you define special behaviour, e.g.
when(clientMock.foo()).thenReturn("bar");

// Then you use the mock instance:
assertEquals("bar", clientMock.foo());