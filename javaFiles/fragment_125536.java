...
@Test
public void testLocationRules() {
    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    kbuilder.add(ResourceFactory.newClassPathResource("locations.drl"), ResourceType.DRL);
    if (kbuilder.hasErrors()) {
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        System.out.println(errors.toString());
        throw new RuntimeException(errors.toString());
    }
    KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
    knowledgeBase.addKnowledgePackages(kbuilder.getKnowledgePackages());
    StatelessKnowledgeSession session = knowledgeBase.newStatelessKnowledgeSession();
    session.setGlobal("user", new User());
    List<VisitedLocation> facts = new ArrayList<VisitedLocation>();
    facts.add(new VisitedLocation("Berlin"));
    facts.add(new VisitedLocation("Paris"));
    facts.add(new VisitedLocation("San Francisco"));
    facts.add(new VisitedLocation("Saigon"));
    session.execute(facts);
}
...