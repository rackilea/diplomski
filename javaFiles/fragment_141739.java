@RunWith(MockitoJUnitRunner.class)
public class ReadWorkJobTest {

    private static final String RIGHT_DATA_FILE_NAME = "test.txt";

    private ReadWorkJob readWorkJob;

    private WorkJobRepository workJobRepository;

    @Before
    public void setUp() throws Exception {
        workJobRepository = Mockito.mock(WorkJobRepository.class);
        when(workJobRepository.findById(any())).thenReturn(null);

        readWorkJob = new ReadWorkJob(workJobRepository); //<--

        logger.info("check point test case setup");
    }

    @Test
    public void testNewIdDBWriter() throws Exception {
        logger.info("check point test case 1");            
        readWorkJob.writeNewIdData(getRightData());
        logger.info(("check point test case 2"));
    }

    private JSONObject getRightData() throws IOException {
        String rightDataString = new String(Files.readAllBytes(Paths.get(RIGHT_DATA_FILE_NAME)));
        JSONObject jsonObject = new JSONObject(rightDataString);
        return jsonObject;
    }
}