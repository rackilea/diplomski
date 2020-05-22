@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    public EntityManagerFactory entityManagerFactory;

    @Bean
    public Job synchronizeProcess(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("synchronizeProcess")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Schedule, Schedule> chunk(10)
                .reader(reader())
                .processor(new ScheduleExectutor())
                .writer(writer())
                .build();
    }

    @Bean
    public JpaItemWriter<Schedule> writer() {
        JpaItemWriter<Schedule> jpaItemWriter = new JpaItemWriter<>();
        jpaItemWriter.setEntityManagerFactory(entityManagerFactory);
        return jpaItemWriter;
    }

    @Bean
    public ItemReader<Schedule> reader() {
        JpaPagingItemReader<Schedule> jpaPagingItemReader = new JpaPagingItemReader<Schedule>();
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        jpaPagingItemReader.setQueryString("SELECT s FROM Schedule s WHERE s.status = 'WAITING'");
        jpaPagingItemReader.setPageSize(10);
        return jpaPagingItemReader;
    }

}