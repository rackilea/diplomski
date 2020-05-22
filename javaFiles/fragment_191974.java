public class MyReasonerFactory implements ReasonerFactory {

    private static final String RULE_LOC = "./prova_rules_M_rdf_7_diffDate.txt";

    static {
        BuiltinRegistry.theRegistry.register(new DiffDateLib());
    }

    @Override
    public Reasoner create(Resource r) {
        final GenericRuleReasoner reasoner = new GenericRuleReasoner(this, r);
        reasoner.setRules(Rule.rulesFromURL(RULE_LOC));
        return reasoner;
    }

    @Override
    public Model getCapabilities() {
        return GenericRuleReasonerFactory.theInstance().getCapabilities();
    }

    @Override
    public String getURI() {
        // TODO NOTE this is just a suggestion
        return "urn:ex:provaRuleReasoner";
    }

}