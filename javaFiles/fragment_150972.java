@Component
public class MyJobs {
    @Autowired
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }
}