@Configuration
@EnableBatchProcessing
@ComponentScan("my.batch.*")
@ImportResource("classpath:batch-config.xml")
@PropertySource(value = "classpath:batch.properties")
public class BatchConfiguration implements BatchConfigurer {

@Autowired
private DataSource dataSource;
private PlatformTransactionManager transactionManager;
private JobRepository jobRepository;
private JobLauncher jobLauncher;
private JobExplorer jobExplorer;

@Override
public JobRepository getJobRepository() throws Exception {
    return jobRepository;
}

@Override
public PlatformTransactionManager getTransactionManager() throws Exception {
    return transactionManager;
}

@Override
public JobLauncher getJobLauncher() throws Exception {
    return jobLauncher;
}

@Override
public JobExplorer getJobExplorer() throws Exception {
    return jobExplorer;
}

@PostConstruct
public void initialize() {
    try {
        transactionManager = new DataSourceTransactionManager(dataSource);
        jobRepository = createJobRepository();

        jobExplorer = createJobExplorer();
        jobLauncher = createJobLauncher();
    } catch (Exception ex) {
        throw  new BatchConfigurationException(ex);
    }
}

private JobRepository createJobRepository() throws Exception {
    JobRepositoryFactoryBean repoFactory = new JobRepositoryFactoryBean();

    repoFactory.setDataSource(dataSource);
    repoFactory.setTransactionManager(transactionManager);
    repoFactory.setTablePrefix(PREFIX);

    repoFactory.afterPropertiesSet();

    return repoFactory.getObject();
}

private JobExplorer createJobExplorer() throws Exception {
    JobExplorerFactoryBean explorerFactory = new JobExplorerFactoryBean();

    explorerFactory.setDataSource(dataSource);
    explorerFactory.setTablePrefix(PREFIX);

    explorerFactory.afterPropertiesSet();

    return explorerFactory.getObject();
}

private JobLauncher createJobLauncher() throws Exception {
    SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
    jobLauncher.setJobRepository(jobRepository);
    jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());

    jobLauncher.afterPropertiesSet();

    return jobLauncher;
}
}