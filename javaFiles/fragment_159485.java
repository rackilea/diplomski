@Provide
Arbitrary<Rule> generateRule() {
    Arbitrary<Double> lowThresholdArb = Arbitraries.doubles()
                                                   .between(0.0, 29.0);
    Arbitrary<Double> highThresholdArb = Arbitraries.doubles()
                                                    .between(30.0, 50.0);

    Arbitrary<RuleConfig> configArb =
        Combinators.combine(lowThresholdArb, highThresholdArb)
                   .as((low, high) -> {
                       Map<String, Object> ruleProps = new HashMap<>();
                       ruleProps.put(Utils.LOW_THRESHOLD, low);
                       ruleProps.put(Utils.HIGH_THRESHOLD, high);
                       RuleConfig ruleConfig = new RuleConfig();
                       ruleConfig.setRuleProps(ruleProps);
                       return ruleConfig;
                   });

    return configArb.map(config -> {
        Rule rule = new Rule();
        rule.setRuleConfig(config);
        return rule;
    });
}