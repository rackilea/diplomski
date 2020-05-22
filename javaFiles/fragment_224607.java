public class MyJobLauncher {
@Autowired
private JobLauncher jobLauncher;
@Autowired
@Qualifier("myJob")
private Job job;
public void run() {
    try {
        String dateParam = new Date().toString();
        JobParameters param = new JobParametersBuilder().addString("date",
                dateParam).toJobParameters();
        JobExecution execution = jobLauncher.run(job, param);
        execution.stop();
    } catch (Exception e) {
        e.printStackTrace();
    }
}