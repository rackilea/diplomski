@Configuration
@EnableBatchProcessing
public class BatchConfig{

    @Bean
    public ResourcelessTransactionManager batchTransactionManager(){
        ResourcelessTransactionManager transactionManager = new ResourcelessTransactionManager();
        return transactionManager;
    }

    @Bean
    protected JobRepository jobRepository(ResourcelessTransactionManager batchTransactionManager) throws Exception{
        MapJobRepositoryFactoryBean jobRepository = new MapJobRepositoryFactoryBean();
        jobRepository.setTransactionManager(batchTransactionManager);
        return (JobRepository)jobRepository.getObject();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        return jobLauncher;
    }

}

@Configuration
public class ImportJobConfig {

    @Bean
    public FlatFileItemReader<Person> importReader(@Value("#{jobParameters[fullPathFileName]}") String pathToFile) {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(pathToFile));
        reader.setLineMapper(new DefaultLineMapper<Person>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"firstName", "lastName"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                setTargetType(Person.class);
            }});
        }});
        return reader;
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Person> writer() {
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(
                new BeanPropertyItemSqlParameterSourceProvider<Person>());
        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer())
                .listener(listener).flow(step1()).end().build();
    }

    @Bean
    public Step step1(@Qualifier("importReader") ItemReader<Person> importReader) {
        return stepBuilderFactory.get("step1").<Person, Person>chunk(10).reader(importReader)
                .processor(processor()).writer(writer()).build();
    }

}

@RestController
public class MyImportController {

    @Autowired private JobLauncher jobLauncher;
    @Autowired private Job importUserJob;

    @RequestMapping(value="/import/file", method=RequestMethod.POST)
    public String create(@RequestParam("file") MultipartFile multipartFile) throws IOException{

        //Save multipartFile file in a temporary physical folder
        String path = new ClassPathResource("tmpuploads/").getURL().getPath();//it's assumed you have a folder called tmpuploads in the resources folder
        File fileToImport = new File(path + multipartFile.getOriginalFilename());
        OutputStream outputStream = new FileOutputStream(fileToImport);
        IOUtils.copy(multipartFile.getInputStream(), outputStream);
        outputStream.flush();
        outputStream.close();       

        //Launch the Batch Job
        JobExecution jobExecution = jobLauncher.run(importUserJob, new JobParametersBuilder()
                .addString("fullPathFileName", fileToImport.getAbsolutePath())
                .toJobParameters());        

        return "OK";
    }

}