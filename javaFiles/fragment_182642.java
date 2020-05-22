public class NotConsoleAndDevCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        return !environment.acceptsProfiles("console", "dev");
    }
}