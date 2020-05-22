@RunWith (MockitoJUnitRunner.class)
public class FooUserTest {
    @Mock Foo f;
    FooUser fUser;

    @Before
    public void init() {
        fUser = new FooUser();
        fUser.setFoo(f);
    }

    @Test
    public void test() {
        fUser.addToFoo("a");
        Mockito.verify(f).addFoo("a");
    }