@Controller
public class MyController {
    private JobExplorer jobExplorer;

    @RequestMapping("/batch/test")
    @ResponseBody
    public String batch() {
        Set<JobExecution> jes = jobExplorer
            .findRunningJobExecutions("firstJob");
        for (JobExecution je : jes) {
            System.out.println(je.isRunning());
        }
        return "Done!";
    }
}