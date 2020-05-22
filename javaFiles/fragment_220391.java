public class FooTest {

    @Test
    public void testFoo() {
        Object expected = // ...
        Object actual = // ...

        assertThat(actual, is(equalsTo(expected)));
    }

}