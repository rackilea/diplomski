@RunWith(PowerMockRunner.class)  // <- important!
@PrepareForTest(Foo.class)       // <- note: Foo.class, NOT Paths.class
public class FooTest {
    @Test
    public void doGetReturnsNullForInvalidPathException() throws IOException {
        // Enable static mocking on Paths
        PowerMockito.mockStatic(Paths.class);

        // Make Paths.get() throw IPE for all arguments
        Mockito.when(Paths.get(any(String.class)))
          .thenThrow(new InvalidPathException("", ""));

        // Assert that method invoking Paths.get() returns null
        assertThat(Foo.doGet(new File("foo"))).isNull();
    }
}