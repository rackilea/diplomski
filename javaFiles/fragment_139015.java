public interface Foo {
    void setBaz(String baz);
    String getProcessedBaz();
}

@RunWith(JMockit.class)
public class FooTest {
    @Injectable
    private Foo mockedFoo = null;

    @Test
    public void testBaz() { 
        new Expectations() {
            private String bazState; // Variable inside Expectations stores the state between calls

            {
                mockedFoo.setBaz(anyString);
                result = new Delegate() {
                    void setBaz(String baz) { bazState = baz; }
                };

                mockedFoo.getProcessedBaz();
                result = new Delegate() {
                    String getProcessedBaz() { return "PROCESSED_" + bazState; }
                };
            }
        };

        mockedFoo.setBaz("ABC");
        assertEquals("PROCESSED_ABC", mockedFoo.getProcessedBaz());
    }
}