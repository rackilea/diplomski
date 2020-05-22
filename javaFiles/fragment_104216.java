@Test
public void testRegisterService() throws Exception {
    long expectedId = 42;

    // We create a new instance of test class under test as usually.
    ServiceRegistartor tested = new ServiceRegistartor();

    // This is the way to tell PowerMock to mock all static methods of a
    // given class
    mockStatic(IdGenerator.class);

    /*
     * The static method call to IdGenerator.generateNewId() expectation.
     * This is why we need PowerMock.
     */
    expect(IdGenerator.generateNewId()).andReturn(expectedId);

    // Note how we replay the class, not the instance!
    replay(IdGenerator.class);

    long actualId = tested.registerService(new Object());

    // Note how we verify the class, not the instance!
    verify(IdGenerator.class);

    // Assert that the ID is correct
    assertEquals(expectedId, actualId);
}