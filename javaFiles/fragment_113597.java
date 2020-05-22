@Component
@Scope( value = "thread", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class GenerateExportThread implements Callable<String> {
    ...
    // this class contains an @Autowired UserInfoBean
    private ISubmissionDao submissionDao;

    public void setSubmissionDao(ISubmissionDao submissionDao) {
        this.submissionDao = submissionDao;
    }
    ...
}