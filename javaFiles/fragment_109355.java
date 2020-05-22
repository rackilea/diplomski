@Singleton
public class AccountController extends Controller {
  private AccountService accountService;

  @Inject
  public Controller(AccountService a) {
      accountService = a;
  }

  public Result addAccount() {
     boolean success = accountService.addAccount();
  }
}