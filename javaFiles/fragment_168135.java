@Configuration
public class DemoJobBatchConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoJobBatchConfiguration.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("applicaionDS")
    public DataSource dataSource;

    @Autowired
    UserWritter userWriter;

    @Bean("demoJob")
    public Job partitionJob(JobNotificationListener listener, JobBuilderFactory jobBuilderFactory,
            @Qualifier("demoPartitionStep") Step demoPartitionStep) {
        return jobBuilderFactory.get("demoJob").incrementer(new RunIdIncrementer()).listener(listener)
                .start(demoPartitionStep).build();
    }

    @Bean(name = "demoPartitionStep")
    public Step demoPartitionStep(Step demoSlaveStep, StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("demoPartitionStep").partitioner("demoPartitionStep", demoPartitioner())
                .gridSize(21).step(demoSlaveStep).taskExecutor(jobTaskExecutor()).build();
    }

    @Bean(name = "demoPartitioner", destroyMethod = "")
    public Partitioner demoPartitioner() {
        DemoPartitioner partitioner = new DemoPartitioner();
        // partitioner.partition(20);
        return partitioner;
    }

    @Bean
    public Step demoSlaveStep(ItemReader<User> demoReader, ItemProcessor<User, User> demoJobProcessor) {
        return stepBuilderFactory.get("demoSlaveStep").<User, User>chunk(3).reader(demoReader)
                .processor(demoJobProcessor).writer(userWriter).build();
    }

    @Bean(name = "demoReader")
    @StepScope
    public JdbcCursorItemReader<User> demoReader(@Value("#{stepExecutionContext[SQL]}") String SQL,
            @Value("#{jobParameters[JOB_PARM]}") String jobParm,
            @Value("#{jobExecutionContext[jobExecutionParameter]}") String jobExecutionParameter) {
        LOGGER.info("---------------------- demoReader ------------------------------- " + SQL);
        LOGGER.info(" jobParm : " + jobParm);
        LOGGER.info(" jobExecutionParameter : " + jobExecutionParameter);

        JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(this.dataSource);
        reader.setFetchSize(200);
        reader.setRowMapper(new BeanPropertyRowMapper<>(User.class));
        reader.setSql(SQL);
        return reader;
    }

    @Bean(name = "demoJobProcessor")
    @StepScope
    public ItemProcessor<User, User> demoJobProcessor() throws Exception {
        LOGGER.info(" DemoJobBatchConfiguration: demoJobProcessor  ");
        return new UserProcessor();
    }

    /*
     * @Bean public ItemWriter<User> demoWriter() { return users -> { for (User user
     * : users) { if (LOGGER.isInfoEnabled()) { LOGGER.info("user read is :: " +
     * user.toString()); } } if (LOGGER.isInfoEnabled()) {
     * LOGGER.info("%%%%%%%%%%%%%%%%%%%%% demoWriter %%%%%%%%%%%%%%%%%%%%% "); } };
     * }
     */

    @Bean
    public TaskExecutor jobTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // there are 21 sites currently hence we have 21 threads
        taskExecutor.setMaxPoolSize(30);
        taskExecutor.setCorePoolSize(25);
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }

}