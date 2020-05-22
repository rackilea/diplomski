@MockClass(realClass = Bar.class)
public static class MockBar {
    private boolean barCalled = false;

    @Mock
    public void bar() {
        this.barCalled = true;
        System.out.println("mocked bar");
    }
}

@Test
public void barShouldCallSuperBar() {
    MockBar mockBar = new MockBar();
    Mockit.setUpMock(Bar.class, mockBar);

    Foo foo = new Foo();
    foo.bar();

    Assert.assertTrue(mockBar.barCalled);

    Mockit.tearDownMocks();
}