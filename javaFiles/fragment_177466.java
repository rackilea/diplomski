// Mock the dependencies:
ValueGenerator vgMock = Mockito.mock(ValueGenerator.class);
when(vgMock.getValue()).thenReturn(7);

// Test your code:
Incrementor inc = new Incrementor();
assertEquals(8, inc.increment(vgMock));