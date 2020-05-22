public class MyController extends Controller {

    private final Provider<AuthChecker> authChecker;

    @Inject
    public MyController(Provider<AuthChecker> authChecker) {
        this.authChecker = authChecker;
    }

    public Promise<Result> index() throws BusinessException {
        authChecker.get()
            .tokenValue(request().username())
            .execute()
            .go();
        // bla bla bla
    }

}