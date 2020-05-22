@Component
@EnableBatchProcessing
@Import() // list with imports as neede
public class JobCreatorComponent {

  @Autowire
  private StepBuilderFactory stepBuilder;

  @Autowire
  private JobBuilderFactory jobBuilder;

  public Job createJob(all the parameters you need) {
     return jobBuilder.get(). ....
  }
}

@RestController
@Import(JobCreatorComponent.class)
public class MyController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobCreatorComponent jobCreator;

    @RequestMapping("/launchjob")
    public String handle() throws Exception {
        try {
            Job job = jobCreator.createJob(... params ...);
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", new Date().getTime()).toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {

        }

        return "Done";
    }
}