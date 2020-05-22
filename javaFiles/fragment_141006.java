@Named
public class SessionIdValidator implements Validator {

    @Resource
    private DataSource dataSource;

    @Inject
    private YourDataService yourDataService;

    // ...
}