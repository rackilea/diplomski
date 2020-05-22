public class FolderServiceImplTest {

    private static final String ANY_FILE_NAME = "";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private ReaderFactory readerFactory;

    @InjectMocks
    FolderServiceImpl sut;

    @Test
    public void getStatus_FileNotExisting_returnStatus3() throws Exception {
        // arrange
        Mockito.doThrow(new FileNotFoundException("UnitTest")).when(readerFactory).createFor(Mockito.any(File.class));
        // act
        int status = sut.getStatus(ANY_FILE_NAME);
        // assert
        Assert.assertThat("status",status,CoreMatchers.equalTo(3));
    }

    @Test
    public void getStatus_ValidFile_returnFileContentAsInt() throws Exception {
        // arrange
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.doReturn(bufferedReader).when(readerFactory).createFor(Mockito.any(File.class));
        Mockito.doReturn("4711").when(bufferedReader).readLine();
        // act
        int status = sut.getStatus(ANY_FILE_NAME);
        // assert
        Assert.assertThat("status",status,CoreMatchers.equalTo(4711));
    }
}