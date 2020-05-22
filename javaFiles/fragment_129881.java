public class FooTest
{
    @Tested Foo _foo;

    @Test
    void restoreInFooCallsSuper(@Mocked final Bar bar)
    {
        new Expectations() {{
            invoke(bar, "restore");
        }};

        _foo.restore();
    }
}