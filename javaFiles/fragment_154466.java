public abstract class DynamicService {
    protected void updateService() {
        // Reinject with the new implementations the members.
        App.getInjector().injectMembers(this);
    }
}

public class PasswordCheckService extends DynamicService  {
    @Inject
    @Named("password")
    private RuleChecker passwordChecker;

    public void changePasswordCheckType(CheckType type) {
        PasswordRuleCheckerProvider.setType(type);
        // Reinject, so you have your new implementation.
        updateService();
    }

    // [...]
}