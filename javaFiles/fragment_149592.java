@RunWith(AndroidJUnit4.class)
public class AssetManagerTests {
    private Instrumentation mInstrumentation;

    @Before
    public void setUp() throws Exception {
        mInstrumentation = InstrumentationRegistry.getInstrumentation();
    }

    @Test
    public final void testAssets() throws IOException {
        final AssetManager assetManager = mInstrumentation.getTargetContext().getAssets();
        assetManager.open("someappfile");
    }
}