@EnableScheduling
@Service
public class BatchScheduled {

    private static final Logger log = LoggerFactory.getLogger(BatchScheduled.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("newsSyncJob")
    private Job newsJobSync;

    /**
     * Scheduled run of the batch
     * @throws Exception
     */
    @Scheduled(cron="0 0/2 * * * ?")
    public void run() throws Exception {
        log.info("newsJobSync started");
        System.out.println("Job Started at :" + new Date());

        JobParameters param = new JobParametersBuilder().addString("newsSyncJob",
                String.valueOf(System.currentTimeMillis())).toJobParameters();

        JobExecution execution = jobLauncher.run(newsJobSync, param);

        log.info("newsJobSync finished with status " + execution.getExitStatus());
    }
}