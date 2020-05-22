public class ServiceManager {

    private static volatile ServiceManager instance;

    public final JiraService jira;
    public final GitService git;
    public final JenkinsService jenkins;

    @Autowired
    private ServiceConfiguration conf;

    private ServiceManager() {
        this.jira = new JiraServiceSynchronousImpl(conf);
        this.git = new JGitGitServiceImpl(conf);
        this.jenkins = new SimpleJenkinsServiceImpl(conf);
    }