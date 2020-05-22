@RunWith(RobolectricGradleTestRunner.class) 
@Config(constants = BuildConfig.class, sdk = 21) public class PinActivityTest {
    @Test
    public void onCreate_shouldInflateLayout() throws Exception {
        PinActivity activity = Robolectric.buildActivity(PinActivity.class).create().get();
        assertNotNull(activity);
    }