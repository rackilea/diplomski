@RunWith(MockitoJUnitRunner.class)
public class FileUploadTests {

    @InjectMocks
    private StorageService storageService;

    @Mock
    private StorageProperties storageProperties;

    @Test(expected = StorageInvalidFileTypeException.class)
    public void shouldCheckTheFileType() {
        Mockito.when(storageProperties.getUploadDir()).thenReturn(Paths
        .get(System.getProperty("jboss.server.data.dir"))
        .resolve("uploads"));

        final Path fileName = Paths.get("MyTestUpload");
        final byte[] content = new String("SomeContent").getBytes();
        final MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "content", fileName.toString(), "text/plain", content);

        storageService.store(mockMultipartFile);
    }

}