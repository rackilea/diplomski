@RunWith(PowerMockRunner.class)
@PrepareForTest({DirectoryStreamReader.class})
public class DirectoryStreamTest {

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void canReadFilesUsingDirectoryStream() throws IOException {
        PowerMockito.mockStatic(Files.class);

        Path directory = Mockito.mock(Path.class);
        DirectoryStream<Path> expected = Mockito.mock(DirectoryStream.class);
        Mockito.when(Files.newDirectoryStream(Mockito.any(Path.class))).thenReturn(expected);

        File fileOne = folder.newFile();
        File fileTwo = folder.newFile();
        Iterator<Path> directoryIterator = Lists.newArrayList(Paths.get(fileOne.toURI()),
                Paths.get(fileTwo.toURI())).iterator();

        Mockito.when(expected.iterator()).thenReturn(directoryIterator);

        Mockito.when(Files.isRegularFile(Mockito.any(Path.class))).thenReturn(true);
        Mockito.when(Files.readAllBytes(Mockito.any(Path.class))).thenReturn("fileOneContents".getBytes()).thenReturn("fileTwoContents".getBytes());

        Map<String, String> fileContentsByName = new DirectoryStreamReader().read(directory);

        Assert.assertEquals(2, fileContentsByName.size());
        Assert.assertTrue(fileContentsByName.containsKey(fileOne.getName()));
        Assert.assertEquals("fileOneContents", fileContentsByName.get(fileOne.getName()));
        Assert.assertTrue(fileContentsByName.containsKey(fileTwo.getName()));
        Assert.assertEquals("fileTwoContents", fileContentsByName.get(fileTwo.getName()));
    }
}