public class FooTest() {

    private Foo foo;
    private Clock mock;

    @Before
    public void setUp() {
        mock = mock(Clock.class);
        foo = new Foo(mock);
    }

    @Test
    public void ensureDifferentValuesWhenMockIsCalled() {
        Instant first = Instant.now();                  // e.g. 12:00:00
        Instant second = first.plusSeconds(1);          // 12:00:01
        Instant thirdAndAfter = second.plusSeconds(1);  // 12:00:02

        when(mock.instant()).thenReturn(first, second, thirdAndAfter);

        foo.someMethod();   // string of first
        foo.someMethod();   // string of second
        foo.someMethod();   // string of thirdAndAfter 
        foo.someMethod();   // string of thirdAndAfter 
    }
}