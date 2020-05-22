@RunWith(PowerMockRunner.class)
@PrepareForTest(X.class)
public class XTest {
        @Test
        public void test() {
                whenNew(MyClass.class).withNoArguments().thenThrow(new  IOException("error message"));

                X x = new X();
                x.y(); // y is the method doing "new MyClass()"

                ..
        }
}