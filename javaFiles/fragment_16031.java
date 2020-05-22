@RunWith(PowerMockRunner.class)
 public class UtilitiesTest {

    @Mock
    private Logger.ALogger aLogger;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this); // for case them used another runner
        Whitebox.setInternalState(CcpProcessorUtilities.class, "LOGGER", aLogger);
    }

    @Test
    public void testLogger() throws Exception {
        Utilities.convertToURl("");
        verify(aLogger).error(eq("Invalid Format"), any(IllegalArgumentException.class));
    }
}