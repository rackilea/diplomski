@RunWith(JUnit4.class)
public class MyTestCase {
    MyClass foo;

    @Before
    public void init() {
        foo = new MyClass();
        foo.loadChildren(new ApplicationContextMock());
    }

    // ...
}