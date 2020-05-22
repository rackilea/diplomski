@RunWith(PowerMockRunner.class)
@PrepareForTest(B.class)
public class BTest {
    @Test public void testClass() throws Exception {
        B b = spy(new B());
        doReturn(42).when(b, "m");
        b.asd();
    }
}