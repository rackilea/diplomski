public class TestFileClass {

@Test(expected = ClassNotFoundException.class)
public void testFuncB() throws ClassNotFoundException {
    FileClass fc = Mockito.spy(new FileClass());
    fc.funcB();
}