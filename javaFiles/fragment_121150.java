public class MyReasonerFactory implements ReasonerFactory

    private static final String RULE_LOC = "/some/directory/in/my/jar/filename.extensiondoesntmatter";

    static {
        // register your builtins
    }

    @Override
    public RuleReasoner create(Resource r) {
        final GenericRuleReasoner reasoner = new GenericRuleReasoner(this, r);
        reasoner.setRules(FBRuleReasoner.loadRules(RULE_LOC));
        return reasoner;
    }

    @Override
    public String getUri() {
        return "urn:ex:yourReasoner";
    }

    @Override
    public Model getCapabilities() {
        // Your capabilities are identical to GenericRuleReasoner's
        return GenericRuleReasonerFactory.theInstance().getCapabilities();
    }
}