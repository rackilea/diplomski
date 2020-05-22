@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = MyTestApplication.class)
public class TestClass {
    @Test
    public void testFunc() {
        // some testing goes here
    }
}