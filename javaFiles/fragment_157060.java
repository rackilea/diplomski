public class RuleApplier {
    private RuleFunction[] steps;

    public RuleApplier(RuleFunction... steps) {
        Objects.requireNonNull(steps);
        this.steps = steps;
    }

    public List<Map<String, String>> apply(List<Map<String, String>> listOfMap) {
        Rules rules = new Rules().getListAddresses(listOfMap);
        for (RuleFunction step : steps) {
            rules = step.apply(rules);
        }
        return rules.fOut();
    }
}