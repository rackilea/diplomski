@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class MainActivityTest {

@Test
public void shouldNotBeNull() throws Exception {
    MainActivity activity = Robolectric.setupActivity(MainActivity.class);
    assertNotNull(activity);
}
}