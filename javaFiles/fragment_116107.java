public FileUploadUnitTest extends JerseyTest {
@Before
    public void before() {
        // to support file upload as a test client
        client().register(MultiPartFeature.class); 
    }
}