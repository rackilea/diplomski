@RunWith(JMockit.class)
public class FooTest {

    @Test
    public void capturing(@Mocked final Foo unused) {
        final Foo expected[] = new Foo[1];
        new Expectations() {{
            new Foo();
            result = new Delegate() {
                void captureIt(Invocation inv) {
                    expected[0] = (Foo) inv.getInvokedInstance();
                }
            };
        }};

        final Foo actual = new Foo();
        assertThat(actual, is(theInstance(expected[0])));
    }

}