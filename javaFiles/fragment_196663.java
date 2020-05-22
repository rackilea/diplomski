@Configuration
public class SimpleJobConfiguration {
    private static final String JOB_NAME = "SimpleTestJob";

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;


    @Bean
    public Job job() throws Exception {
        SimpleJobBuilder jobBuilder = this.jobs.get(createJobName(JOB_NAME)).start(firstStep());

        for ... {
            jobBuilder.next(createAStep( ... params ...));
        }

        return standardJob.build();
    }

    public Step createAStep(String name, ... needed parameters ...) throws Exception {
        StepBuilder stepBuilder = this.steps.get(name);

        build your step

        return standardStep1.build();
    }
}