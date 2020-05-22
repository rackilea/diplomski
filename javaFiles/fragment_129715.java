@RunWith(PowerMockRunner.class)
@PrepareForTest(IOHelper.class)
public class IOHelperTest {
    @BeforeClass
    public static void setup() {
        final ConsoleReader mockCR = mock(ConsoleReader.class);
        // Any mockery on your mockCR you need.
        // doReturn(...).when(mockCR).readLine();, etc.

        PowerMock.whenNew(ConsoleReader.class).thenReturn(mockCR);
    }
}