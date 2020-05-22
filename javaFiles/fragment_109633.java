@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ExtractionBatchConfiguration.class })
public class ExtractBatchTestCase {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    @Qualifier("extractJob1")
    private Job job;

    private JobLauncherTestUtils jobLauncherTestUtils;

    @Before
    public void setup() throws Exception {      
        jobLauncherTestUtils = new JobLauncherTestUtils();
        jobLauncherTestUtils.setJobLauncher(jobLauncher);
        jobLauncherTestUtils.setJobRepository(jobRepository);
    }

    @Test
    public void testGeneratedFiles() throws Exception {     
        jobLauncherTestUtils.setJob(job);
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertNotNull(jobExecution);
        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
        // ... other assert
    }

}