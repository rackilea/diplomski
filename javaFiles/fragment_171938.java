@RunWith(MockitoJUnitRunner.class)
public class TestCase1 {

    @Mock
    private Foo<Bar> fooMock;

    @Test
    public void testBar() {
        fooMock.doIt(Matchers.<Bar>any());
        Mockito.verify(fooMock, Mockito.times(1)).doIt(Matchers.<Bar>any());
    }
}