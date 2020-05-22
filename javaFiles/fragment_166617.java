@Controller
public class MyController {
    private JobRepository batchJobRepository;

    @RequestMapping("/batch/test")
    @ResponseBody
    public String batch() {
        Set<JobExecution> jes = batchJobRepository
            .getJobExecutionDao()
            .findRunningJobExecutions("firstJob");
        for (JobExecution je : jes) {
            System.out.println(je.isRunning());
        }
        return "Done!";
    }
}