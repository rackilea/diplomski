public class AppAOrB implements Condition {
    public AppAOrB() {
        super();
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env = conditionContext.getEnvironment();
        return env.containsProperty("APP_A")||env.containsProperty("APP_B");
    }
}