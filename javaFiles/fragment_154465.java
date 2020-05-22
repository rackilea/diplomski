public class MyModule extends AbstractModule {

    public void configure() {
       bind(RuleChecker.class).annotatedWith(named("password")).toProvider(PasswordRuleCheckerProvider.class);
       bind(RuleChecker.class).annotatedWith(named("login")).toProvider(LoginRuleCheckerProvider.class);
    }
}

public static class PasswordRuleCheckerProvider implements Provider<RuleChecker> {

    private static CheckType type = CheckType.ALPHANUMERIC;
    // static type setter.

    public RuleChecker get() {
        // it would even be better if you could use singletons here.
        switch(type) {
            case LENGTH:
                return new LengthCheck();
            case ALPHANUMERIC:
                return new AlphanumericCheck();
            case ALPHALENGTH:
                return new AlphaAndLenghtCheckAdapter();
            case NONE:
            default:
                return NoCheck();
        }
    }
}
// Almost same provider for your LoginRuleCheckerProvider. You could do something generic.