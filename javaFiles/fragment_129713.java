private final IOHelper mySpy = spy(IOHelper.getInstance());

@Before
public void setup() {
    final ConsoleReader mockCR = mock(ConsoleReader.class);
    // Any mockery on your mockCR you need.
    // doReturn(...).when(mockCR).readLine();, etc.
    doReturn(mockCR).when(mySpy).getConsoleReader();
}