@Test
public void should_calculate_five_times() {
    // Create mock object
    Dependency dependencyMock = Mockito.mock(Dependency.class);
    // Simulate the behaviour of the mock object
    Mockito.when(dependencyMock.doWork()).thenReturn(2);

    // Create object under test
    Thing thingToTest = new Thing();
    // Inject mock object
    thingToTest.setDependency(dependencyMock);
    // Execute method to test
    thingToTest.calculate(5);

    // Expected: dependency.doWork() should have been called 5 times
    Mockito.verify(dependencyMock, Mockito.times(5)).doWork();
    // Since dependencyMock returns 2, when doWork() is called, value should be 10
    Assert.assertEquals(10, thingToTest.getValue());
}