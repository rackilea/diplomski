public class RuleArbitraryProvider implements ArbitraryProvider {

    @Override
    public boolean canProvideFor(TypeUsage targetType) {
        return targetType.isOfType(Rule.class);
    }

    @Override
    public Set<Arbitrary<?>> provideFor(TypeUsage targetType, SubtypeProvider subtypeProvider) {
        return Collections.singleton(generateRule());
    }

    private Arbitrary<Rule> generateRule() {
        // Put here the code from above
        ...
    }
}