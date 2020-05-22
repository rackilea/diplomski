private final IOHelper ioHelper= IOHelper.getInstance();

@Before
public void setup() {
    final ConsoleReader mockCR = mock(ConsoleReader.class);
    // Any mockery on your mockCR you need.
    // doReturn(...).when(mockCR).readLine();, etc.
    ioHelper.cr = mockCR;
}