public class ThreeMinuteRun {

    ...

    @Before
    public void setUp() throws Exception {
        AA.start();
    }

    @After
    public void tearDown() throws Exception {
        AA.stop();
    }

    ...

    @Test
    public void testAddListener() {
        AA.addListener(new DetectionListener());
    }
}